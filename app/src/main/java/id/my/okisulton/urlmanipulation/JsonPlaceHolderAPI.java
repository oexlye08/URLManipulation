package id.my.okisulton.urlmanipulation;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderAPI {

    //https://jsonplaceholder.typicode.com/posts
    @GET("posts")
    Call<List<Post>> getPosts();

    //https://jsonplaceholder.typicode.com/posts/2/comments
    @GET("posts/{id}/comments")
    Call<List<Comment>> getComments(@Path("id") int postId);

    @GET
    Call<List<Comment>> getCommentsUrl(@Url String url);

    //https://jsonplaceholder.typicode.com/posts?userId=1
    @GET("posts")
    Call<List<Post>> getPost(@Query("userId") int userId);


    //https://jsonplaceholder.typicode.com/posts?userId=1&_sort=id&_order=desc
    @GET("posts")
    Call<List<Post>> getPos(@Query("userId") int userId,
                            @Query("_sort") String sort,
                            @Query("_order") String order
    );

    //https://jsonplaceholder.typicode.com/posts?userId=2&userId=4&_sort=id&_order=desc
    @GET("posts")
    Call<List<Post>> getPosDouble(
                            @Query("userId") int userId,
                            @Query("userId") int userId2,
                            @Query("_sort") String sort,
                            @Query("_order") String order
    );

    //https://jsonplaceholder.typicode.com/posts?userId=1&userId=2&userId=3&_sort=id&_order=desc
    @GET("posts")
    Call<List<Post>> getPosAray(@Query("userId") Integer[] userId,
                                @Query("_sort") String sort,
                                @Query("_order") String order
    );

    //https://jsonplaceholder.typicode.com/posts?_order=desc&userId=1&_sort=id
    @GET("posts")
    Call<List<Post>> getPostMap(@QueryMap Map<String, String> parameters);

    //https://jsonplaceholder.typicode.com/posts
    @POST("posts")
    Call<Post> createPosts(@Body Post post);

    //https://jsonplaceholder.typicode.com/posts
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPostFormUrl(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );

    //https://jsonplaceholder.typicode.com/posts
    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPostHashMap(@FieldMap Map<String, String> fields);


    //https://jsonplaceholder.typicode.com//posts/1
    @PUT("posts/{id}")
    Call<Post> putPost(@Path("id") int id, @Body Post post);

    //https://jsonplaceholder.typicode.com/posts/1
    @PATCH("posts/{id}")
    Call<Post> patchPost(@Path("id") int id, @Body Post post);

   //https://jsonplaceholder.typicode.com/posts/1
    @DELETE("posts/{id}")
    Call<Void> deletePosts(@Path("id") int id);
}
