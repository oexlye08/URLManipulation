package id.my.okisulton.urlmanipulation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.POST;

public class MainActivity extends AppCompatActivity {
    private JsonPlaceHolderAPI jsonPlaceHolderAPI;
    TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_result = findViewById(R.id.text_view_result);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        jsonPlaceHolderAPI = retrofit.create(JsonPlaceHolderAPI.class);

        /**
         * GET
         * **/
//        getPosts();
//        getComments();
//        getCommentsUrl();
//        getPost();
//        getPos();
//        getPosDouble();
//        getPosAray();
//        getPostMap();

        /**
         * POST
         * **/

//        createPosts();
//        createPostFormUrl();
//        createPostHashMap();
//        putPost();
//        patchPost();
        deletePost();
    }

    private void getPosts() {
        Call<List<Post>> call = jsonPlaceHolderAPI.getPosts();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    tv_result.setText("Code : " +response.body());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID : " +post.getId() +"\n";
                    content += "User ID : " +post.getUserId() +"\n";
                    content += "Title : " +post.getTitle() +"\n";
                    content += "Text : " +post.getText() +"\n";

                    tv_result.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }

    private void getComments() {
        Call<List<Comment>> call = jsonPlaceHolderAPI.getComments(3);
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                assert response.body() !=null;
                Log.d("tampil", response.toString());
                if (!response.isSuccessful()){
                    tv_result.setText("Code : " + response.code());
                    return;
                }

                List<Comment> comments = response.body();
                for (Comment comment : comments){
                    String content = "";
                    content += "ID : " +comment.getId() + "\n";
                    content += "Post ID : " +comment.getPosId() + "\n";
                    content += "Name : " +comment.getName() + "\n";
                    content += "Email : " +comment.getEmail() + "\n";
                    content += "Text : " +comment.getText() + "\n";

                    tv_result.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }

    private void getCommentsUrl() {
        Call<List<Comment>> call = jsonPlaceHolderAPI.getCommentsUrl("posts/3/comments");
        call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse(Call<List<Comment>> call, Response<List<Comment>> response) {
                assert response.body() !=null;
                Log.d("tampil", response.toString());
                if (!response.isSuccessful()){
                    tv_result.setText("Code : " + response.code());
                    return;
                }

                List<Comment> comments = response.body();
                for (Comment comment : comments){
                    String content = "";
                    content += "ID : " +comment.getId() + "\n";
                    content += "Post ID : " +comment.getPosId() + "\n";
                    content += "Name : " +comment.getName() + "\n";
                    content += "Email : " +comment.getEmail() + "\n";
                    content += "Text : " +comment.getText() + "\n";

                    tv_result.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Comment>> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }

    private void getPost() {
        Call<List<Post>> call = jsonPlaceHolderAPI.getPost(4);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    tv_result.setText("Code : " +response.body());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID : " +post.getId() +"\n";
                    content += "User ID : " +post.getUserId() +"\n";
                    content += "Title : " +post.getTitle() +"\n";
                    content += "Text : " +post.getText() +"\n";

                    tv_result.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });

    }

    private void getPos() {
        Call<List<Post>> call = jsonPlaceHolderAPI.getPos(4, "id", "desc");
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()){
                    tv_result.setText("Code : " +response.body());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID : " +post.getId() +"\n";
                    content += "User ID : " +post.getUserId() +"\n";
                    content += "Title : " +post.getTitle() +"\n";
                    content += "Text : " +post.getText() +"\n";

                    tv_result.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });

    }

    private void getPosDouble() {
        Call<List<Post>> call = jsonPlaceHolderAPI.getPosDouble(2,4, "id", "desc");
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                assert response.body() != null;
                Log.d("tampil", response.toString());
                if (!response.isSuccessful()){
                    tv_result.setText("Code : " +response.body());
                    return;
                }


                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID : " +post.getId() +"\n";
                    content += "User ID : " +post.getUserId() +"\n";
                    content += "Title : " +post.getTitle() +"\n";
                    content += "Text : " +post.getText() +"\n";

                    tv_result.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }

    private void getPosAray() {
        Call<List<Post>> call = jsonPlaceHolderAPI.getPosAray(new Integer[]{1,2,3} ,"id", "desc");
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                assert response.body() !=null;
                Log.d("tampil", response.toString());
                if (!response.isSuccessful()){
                    tv_result.setText("Code : " +response.body());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID : " +post.getId() +"\n";
                    content += "User ID : " +post.getUserId() +"\n";
                    content += "Title : " +post.getTitle() +"\n";
                    content += "Text : " +post.getText() +"\n";

                    tv_result.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }

    private void getPostMap() {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("userId", "1");
        parameters.put("_sort", "id");
        parameters.put("_order", "desc");
        Call<List<Post>> call = jsonPlaceHolderAPI.getPostMap(parameters);
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                assert response.body() !=null;
                Log.d("tampil", response.toString());

                if (!response.isSuccessful()){
                    tv_result.setText("Code : " +response.body());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    String content = "";
                    content += "ID : " +post.getId() +"\n";
                    content += "User ID : " +post.getUserId() +"\n";
                    content += "Title : " +post.getTitle() +"\n";
                    content += "Text : " +post.getText() +"\n";

                    tv_result.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }

    private void createPosts() {
        Post post = new Post(23,"new title", "new Body");
        Call<Post> call = jsonPlaceHolderAPI.createPosts(post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                assert response.body() !=null;
                Log.d("tampil", response.body().getText());

                if (!response.isSuccessful()){
                    tv_result.setText("code : " +response.code());
                    return;
                }

                Post postResponse = response.body();

                String content = "";
                content += "Code : " + response.code() + "\n";
                content += "ID : " + postResponse.getId() + "\n";
                content += "User Id : " + postResponse.getUserId() + "\n";
                content += "Title : " + postResponse.getTitle() + "\n";
                content += "Text : " + postResponse.getText() + "\n\n";

                tv_result.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }

    private void createPostFormUrl() {
        Call<Post> call = jsonPlaceHolderAPI.createPostFormUrl(23, "jajal title", "jajal text");

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    tv_result.setText(response.code());
                    return;
                }

                Post postResponse = response.body();
                String content = "";
                content += "Code : " + response.code() + "\n";
                content += "ID : " + postResponse.getId() + "\n";
                content += "User Id : " + postResponse.getUserId() + "\n";
                content += "Title : " + postResponse.getTitle() + "\n";
                content += "Text : " + postResponse.getText() + "\n\n";

                tv_result.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }

    private void createPostHashMap() {

        Map<String, String> fields = new HashMap<>();
        fields.put("userId", "50");
        fields.put("title", "jajal title map");
        fields.put("body", "jajal text map");

        Call<Post> call = jsonPlaceHolderAPI.createPostHashMap(fields);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    tv_result.setText(response.code());
                    return;
                }

                Post postResponse = response.body();

                String content = "";
                content += "Code : " + response.code() + "\n";
                content += "Id : " + postResponse.getId() + "\n";
                content += "User Id : " + postResponse.getUserId() + "\n";
                content += "Title : " + postResponse.getTitle() + "\n";
                content += "Text : " + postResponse.getText() + "\n\n";

                tv_result.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }

    private void putPost() {
        Post post = new Post(5, null, "nothing wkwkwk");

        Call<Post> call = jsonPlaceHolderAPI.putPost(5, post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    tv_result.setText(response.code());
                    return;
                }

                Post postResponse = response.body();

                String content = "";
                content += "Code : " + response.code() + "\n";
                content += "Id : " + postResponse.getId() + "\n";
                content += "User Id : " + postResponse.getUserId() + "\n";
                content += "Title : " + postResponse.getTitle() + "\n";
                content += "Text : " + postResponse.getText() + "\n\n";

                tv_result.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }


    private void patchPost() {
        Post post = new Post(5, null, "nothing wkwkwk");

        Call<Post> call = jsonPlaceHolderAPI.patchPost(5, post);
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()){
                    tv_result.setText(response.code());
                    return;
                }

                Post postResponse = response.body();

                String content = "";
                content += "Code : " + response.code() + "\n";
                content += "Id : " + postResponse.getId() + "\n";
                content += "User Id : " + postResponse.getUserId() + "\n";
                content += "Title : " + postResponse.getTitle() + "\n";
                content += "Text : " + postResponse.getText() + "\n\n";

                tv_result.setText(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }


    private void deletePost() {
        Call<Void> call = jsonPlaceHolderAPI.deletePosts(5);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                tv_result.setText("code : " +response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }
}
