package kodman.appforpixeltex.mvp.model;

import retrofit.http.GET;
import rx.Observable;

public interface WallpaperServis {
    final String SERVICE_ENDPOINT = "https://dl.dropboxusercontent.com/u/746330/facts.json";
    final String SERVICE_ACCESS_KEY = "https://api.unsplash.com/photos/?client_id=cc9e9cbae3e04dc08e2eeef9a30b4a86368ff10b0c2c7086446247cbb1f75017";
    /**
     * Use Retrofit to get JSON from URL, then parse it.
     * @return Observable
     */
    @GET("/")
    Observable<Wallpaper> getWa();
        }