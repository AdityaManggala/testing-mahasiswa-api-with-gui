package mahasiswa.maven;

import com.google.gson.Gson;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ApacheHttp {

    public static void main(String[] args) {
        Gson gson = new Gson();
        try {
//            String result = sendPOST("adit","123");
//            System.out.println(result);
            String hasil = ApacheHttp.SendGET();

            ResponNew res = gson.fromJson(hasil,ResponNew.class);
            if (res.status==1 ){
                System.out.println(res);
            }else {
                System.out.println("gagal say");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String sendPOSTLogin( String nama, String password) throws IOException {

        String result = "";
        HttpPost post = new HttpPost("https://tes-api-mahasiswa.000webhostapp.com/reqMethod.php");

        // add request parameters or form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("nama", nama));
        urlParameters.add(new BasicNameValuePair("pass", password));
//        urlParameters.add(new BasicNameValuePair("custom", "secret"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){

            result = EntityUtils.toString(response.getEntity());

//            result
        }

        return result;
    }

    public static String sendPOSTRegister( String nama,String npm, String password, String jurusan, String gender, String alamat) throws IOException {

        String result = "";
        HttpPost post = new HttpPost("https://tes-api-mahasiswa.000webhostapp.com/reqMethod.php");

        // add request parameters or form parameters
        List<NameValuePair> urlParameters = new ArrayList<>();
        urlParameters.add(new BasicNameValuePair("nama", nama));
        urlParameters.add(new BasicNameValuePair("npm", npm));
        urlParameters.add(new BasicNameValuePair("pass", password));
        urlParameters.add(new BasicNameValuePair("jurusan", jurusan));
        urlParameters.add(new BasicNameValuePair("jenis_kelamin", gender));
        urlParameters.add(new BasicNameValuePair("alamat", alamat));
//        urlParameters.add(new BasicNameValuePair("custom", "secret"));

        post.setEntity(new UrlEncodedFormEntity(urlParameters));

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(post)){

            result = EntityUtils.toString(response.getEntity());

//            result
        }

        return result;
    }

    public static String SendGET() throws IOException {

        String result = "";
        HttpGet get= new HttpGet("https://tes-api-mahasiswa.000webhostapp.com/reqMethod.php");

        // add request parameters or form parameters

        try (CloseableHttpClient httpClient = HttpClients.createDefault();
             CloseableHttpResponse response = httpClient.execute(get)){

            result = EntityUtils.toString(response.getEntity());

        }

        return result;
    }

}

