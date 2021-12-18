import javax.security.sasl.SaslServer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class InputDownLoader implements InputLoader{
    @Override
    public List<String> loadInputFromSource(String source) {
        try {
            var url = new URL("https://adventofcode.com/2021/day/" + source + "/input");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Cookie", "session=53616c7465645f5fb9a0c0c83102a857ecf1b23b76f103b65059baf5b5c793046bf97c23ad89a39b373925afc3fcef83");
            try(var in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                var result = new ArrayList<String>();
                while ((inputLine = in.readLine()) != null) {
                    result.add(inputLine);
                }
                connection.disconnect();
                return result;
            } catch (Exception e) {
                System.out.println("Error during reading remote content");
                return Collections.emptyList();
            }
        } catch (MalformedURLException e) {
            System.out.println("Bad url format!");
            return Collections.emptyList();
        } catch (IOException e) {
            System.out.println("Error during request!");
            return Collections.emptyList();
        }
    }
}
