package kodman.appforpixeltex.mvp.presenter;

import android.service.wallpaper.WallpaperService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import kodman.appforpixeltex.mvp.model.Wallpaper;
import kodman.appforpixeltex.mvp.view.MvpView;
import kodman.appforpixeltex.mvp.view.WallpaperListView;
import retrofit.RestAdapter;
import rx.functions.Func1;

public class WallpaperPresenter implements MvpPresenter<WallpaperListView>{

private final static String TAG = "FactPresenter";

private WallpaperListView view;
private List<Wallpaper> facts;

public WallpaperPresenter() {
        facts = new ArrayList<>();
        }

/**
 * asynchronous function to start load Fact list
 *
 */
public void startLoadFacts() {
        if(view == null){
        return;
        }

        view.showLoading();

        // User Retrofit to get JSON object
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(WallpaperService.SERVICE_ENDPOINT).build();
    WallpaperService restService = restAdapter.create(WallpaperService.class);
        restService.getWallpaper()
        .map(new Func1<Wallpaper,Wallpaper>() {
        Iterator<Wallpaper> iterator = list.iterator();
                    @Override
                    public Wallpaper call(Wallpaper country) {
                        /**
                         * Use Object stream of RxJava to filter null list item
                         */
                        List<Wallpaper> list = country.getRows();
                        if(list != null){
        while(iterator.hasNext()){
        Fact fact = iterator.next();
        if(TextUtils.isEmpty(fact.getTitle())){
        iterator.remove();
        }
        }
        }
        return country;
        }
        }).subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<Country>() {
@Override
public void onCompleted() {
        view.hideLoading();
        view.showResult(facts);
        }

@Override
public void onError(Throwable e) {
        view.hideLoading();
        view.showError(e.getMessage());
        }

@Override
public void onNext(Country country) {
        List<Fact> list = country.getRows();
        facts.clear();
        facts.addAll(list);
        view.showTitle(country.getTitle());
        }
        });
        }
@Override
public void attachView(FactListView view) {
        this.view = view;
        }

@Override
public void detachView(boolean retainInstance) {

        }
