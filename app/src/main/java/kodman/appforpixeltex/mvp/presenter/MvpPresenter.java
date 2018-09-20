package kodman.appforpixeltex.mvp.presenter;

import kodman.appforpixeltex.mvp.view.MvpView;

/**
 * Created by dream on 16/7/6.
 */
public interface MvpPresenter<V extends MvpView> {

    /**
     * Bind presenter with MvpView
     * @param view
     */
    public void attachView(V view);

    /**
     * unBind
     * @param retainInstance
     */
    public void detachView(boolean retainInstance);

}
