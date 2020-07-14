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

        getPosts();
//        getComments();
//        getPost();
//        getPos();
//        getPosDouble();
//        getPosAray();
//        getPostMap();

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
}
