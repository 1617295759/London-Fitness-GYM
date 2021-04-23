import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.junit.Test;
import team.gym.MyUtils.VideoPlayer;

/** 测试文件
* */
public class TestVideo extends Application {
    /**
     * Description:    简易的多媒体播放器，以实现媒体控制栏，
     *    两种调用方式：PlayerController.Popup(String URL);  弹窗式窗口调用
     *                  PlayerController.newInstance(String URL),嵌入场景图式调用，返回一个Node类；
     *
     *    支持调用的音频格式：
     *          MP3；包含非压缩PCM的AIFF；
     *          包含非压缩PCM的WAV；
     *          使用AAC音频的MPEG-4;
     *
     *    支持调用的视频格式：
     *          包含VP6视频和MP3音频的FLV；
     *          使用H.264/AVC视频压缩的MPEG-4（MP4）
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        //创建测试窗口
        primaryStage.setTitle("Test Meida");
        Group root = new Group();
        BorderPane pane = new BorderPane();

        root.getChildren().add(pane);
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER);
        pane.setBottom(hbox);
        Button popup = new Button("Popup");
        Button popup2 = new Button("Popup small");
        hbox.getChildren().addAll(popup,popup2);


        //测试嵌入式调用
        VideoPlayer player = VideoPlayer.newInstance(getClass().getResource("/statics/videos/TestMedia.MP4").toString());
        pane.setCenter(player);
        pane.setAlignment(player,Pos.CENTER);


        //测试弹窗式调用
        popup.setOnAction((ActionEvent e)->{
            VideoPlayer.popup(getClass().getResource("/statics/videos/TestMedia.MP4").toString());
        });
        popup2.setOnAction((ActionEvent e)->{
            VideoPlayer.popup(getClass().getResource("/statics/videos/TestMedia.MP4").toString(),550,400);
        });


        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
