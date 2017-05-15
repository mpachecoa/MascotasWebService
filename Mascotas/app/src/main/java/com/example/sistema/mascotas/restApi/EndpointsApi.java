package com.example.sistema.mascotas.restApi;

import com.example.sistema.mascotas.model.Mascota;
import com.example.sistema.mascotas.restApi.model.FollowsIdUserResponse;
import com.example.sistema.mascotas.restApi.model.FotosLikeResponse;
import com.example.sistema.mascotas.restApi.model.MascotasResponse;

import static com.example.sistema.mascotas.restApi.ConstantRestApi.*;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface EndpointsApi {

    @GET(URL_GET_USER)
    Call<Mascota> getUser(@Path("user-id") String id);

    @GET(URL_GET_RECENT_MEDIA_USER)
    Call<FotosLikeResponse> getRecentMedia(@Path("user-id") String id);

    @GET(ConstantRestApi.URL_SEARCH_USER)
    Call<Mascota> getSearchUser(@Query("q") String q, @Query("access_token") String access_token);

    @GET(ConstantRestApi.URL_GET_FOLLOWS_USER)
    Call<MascotasResponse> getFollowsUser();

}
