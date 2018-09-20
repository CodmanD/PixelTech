package kodman.appforpixeltex.mvp.view;



import java.util.List;

import kodman.appforpixeltex.mvp.model.Fact;
import kodman.appforpixeltex.mvp.model.Wallpaper;
import kodman.appforpixeltex.mvp.view.MvpView;

/**
 * Created by dream on 16/7/6.
 */
public interface FactListView extends MvpView {

    /**
     * show loading view
     */
    void showLoading();

    /**
     * hide loading view when finish load or exception
     */
    void hideLoading();

    /**
     * show error message
     * @param msg
     */
    void showError(String msg);

    /**
     * show list item
     * @param list
     */
    void showResult(List<Wallpaper> list);

    /**
     * update action bar title
     * @param title
     */
    void showTitle(String title);

}
