package chile.maps.biblioteca;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.eclipse.paho.android.service.MqttAndroidClient;
import org.eclipse.paho.client.mqttv3.IMqttActionListener;
import org.eclipse.paho.client.mqttv3.IMqttToken;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;

public class Mqtt_act extends AppCompatActivity {


    static String MQTTHOST="tcp://tailor.cloudmqtt.com:13161";
    static String USERNAME="dvwcshrn";
    static String PASSWORD="eCtnO7FVBDkU";
    String topicStr = "LIBRO";

    MqttAndroidClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mqtt_act);

        String clientId = MqttClient.generateClientId();

        client = new MqttAndroidClient(this.getApplicationContext(),MQTTHOST,clientId);
        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName(USERNAME);
        options.setPassword(PASSWORD.toCharArray());

        try {
            IMqttToken token = client.connect(options);
            token.setActionCallback(new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    // We are connected
                    Toast.makeText(getBaseContext(), "SE HA CONECTADO",Toast.LENGTH_LONG).show();
                }

                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable exception) {
                    // Something went wrong e.g. connection timeout or firewall problems
                    Toast.makeText(getBaseContext(), "NO SE HA ESTABLECIDO CONEXION",Toast.LENGTH_LONG).show();
                }
            });
        } catch (MqttException e) {
            e.printStackTrace();
        }

    }

    public void mqttREVIVAL(View v){
        String topic = topicStr;
        String message = "REVIVAL";

        try{
            client.publish(topic,message.getBytes(),0,false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void mqttFARENHEITH(View v){
        String topic = topicStr;
        String message = "FARENHEITH";

        try{
            client.publish(topic,message.getBytes(),0,false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void mqttALQUIMISTA(View v){
        String topic = topicStr;
        String message = "ALQUIMISTA";

        try{
            client.publish(topic,message.getBytes(),0,false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void mqttPODER(View v){
        String topic = topicStr;
        String message = "PODER";

        try{
            client.publish(topic,message.getBytes(),0,false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void mqttDESPERTAR(View v){
        String topic = topicStr;
        String message = "DESPERTAR";

        try{
            client.publish(topic,message.getBytes(),0,false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
