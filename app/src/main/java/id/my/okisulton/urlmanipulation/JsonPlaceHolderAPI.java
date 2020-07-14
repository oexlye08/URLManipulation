package id.my.okisulton.urlmanipulation;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

public interface JsonPlaceHolderAPI {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);

    @GET("posts")
    Call<List<Post>> getPost(@Query("userId") int userId);

    @GET("posts")
    Call<List<Post>> getPos(@Query("userId") int userId,
                            @Query("_sort") String sort,
                            @Query("_order") String order
    );

    @GET("posts")
    Call<List<Post>> getPosAray(@Query("userId") Integer[] userId,
                                @Query("_sort") String sort,
                                @Query("_order") String order
    );

    @GET("posts")
    Call<List<Post>> getPostMap(@QueryMap Map<String, String> parameters);
}
