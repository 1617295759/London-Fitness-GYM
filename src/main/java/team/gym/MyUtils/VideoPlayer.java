package team.gym.MyUtils;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import team.gym.Controller.PlayerController;

import java.io.IOException;

/** Util to play video  Simple multimedia player achieving media control bar
 *
 */
public class VideoPlayer extends AnchorPane {

    private static VideoPlayer videoPlayer;
    private PlayerController controller;

    public PlayerController getController(){   //提供控制器对象的调用接口
        return this.controller;
    }


    private VideoPlayer(String mediaUrl){
        try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/FXML/player.fxml"));
            Parent root = fxmlloader.load();
            controller = fxmlloader.getController();
            this.getChildren().add(root);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setSize(int width,int height){
        if(videoPlayer.getController().getPopup())
            return ;
        videoPlayer.getController().setMediaPlayer(width,height);
    }

    /**PlayerController.newInstance(String URL) :  embedded scene schema,returns a Node class
     *
     * @param mediaUrl video URL
     * @return
     */
    //default 500*400
    public static VideoPlayer newInstance(String mediaUrl){
        return newInstance(mediaUrl,600,400);
    }
    public static VideoPlayer newInstance(String mediaUrl, int width, int height){
        videoPlayer = new VideoPlayer(mediaUrl);
        videoPlayer.getController().start(mediaUrl,false,width,height);
        return videoPlayer;
    }

    /**way to call for :
     * PlayerController.Popup(String URL):  popup
     *
     * @param mediaUrl video URL
     * @return
     */
    //default 800*600
    public static VideoPlayer popup(String mediaUrl){
        return popup(mediaUrl,800,600);
    }
    public static VideoPlayer popup(String mediaUrl, int width, int height){
       videoPlayer = new VideoPlayer(mediaUrl);
        videoPlayer.getController().start(mediaUrl,true,width,height);
        Scene scene = new Scene(videoPlayer,width,height);
        videoPlayer.getController().setScene(scene);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Media Player");
        primaryStage.setScene(scene);

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>(){
            @Override
            public void handle(WindowEvent event) {
                videoPlayer.getController().destroy();
            }
        });
        primaryStage.show();
        return videoPlayer;
    }
}
