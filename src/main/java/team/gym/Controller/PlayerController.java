package team.gym.Controller;

import de.felixroske.jfxsupport.FXMLController;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;
import team.gym.MyUtils.VideoPlayer;
/**
 * Controller to control Video play page
 */
@FXMLController
public class PlayerController {
    @FXML Button playBT;
    @FXML Button stopBT;
    @FXML Button maxBT;
    @FXML Button volumeBT;
    @FXML Label timeLB;
    @FXML Slider processSD;
    @FXML Slider volumeSD;
    @FXML MediaView mediaView;
    @FXML VBox controlBar;
    @FXML BorderPane mediaPane;
    @FXML AnchorPane  anchorPane;

    //控件素材图片
    private String playIcon  = getClass().getResource("/statics/icon/play.png").toString();
    private String pauseIcon  = getClass().getResource("/statics/icon/pause.png").toString();
    private String stopIcon  = getClass().getResource("/statics/icon/stop.png").toString();
    private String volOffIcon  = getClass().getResource("/statics/icon/volume_off.png").toString();
    private String volOnIcon  = getClass().getResource("/statics/icon/volume_On.png").toString();
    private String maxIcon  = getClass().getResource("/statics/icon/max.png").toString();

    private MediaPlayer mediaPlayer;
    private Media media;
    private String url;
    private boolean popup;
    private Scene scene ;

    private boolean atEndOfMedia = false;
    private final boolean repeat = false;
    private double volumeValue;
    private Duration duration ;
    private int mediaHeight;
    private int mediaWidth;

    private int currentHeight;
    private int currentWidth;

    public void setScene(Scene scene){
        this.scene = scene;
    }


    //程序初始化：设置按钮图标
    public void initialize(){

        setIcon(playBT,playIcon,25);
        setIcon(stopBT,stopIcon,25);
        setIcon(volumeBT,volOnIcon,15);
        setIcon(maxBT,maxIcon,25);
    }
    //程序启动项，传入必要参数
    public void start(String url,boolean popup,int width,int height){
        this.url = url;
        this.popup = popup;

        //MediaView设置
        media = new Media(url);
        mediaPlayer = new MediaPlayer(media);
        mediaView.setMediaPlayer(mediaPlayer);


        setMediaPlayer(width,height);

        setMediaViewOnClick();
        setPlayButton();
        setStopButton();
        setVolumeButton();
        setVolumeSD();
        setProcessSlider();
        setMaximizeButton();

    }


    public void setMediaPlayer(int width, int height){
        mediaPlayer.setCycleCount(repeat ? MediaPlayer.INDEFINITE : 1);
        mediaPlayer.setOnReady(() -> {
            duration = mediaPlayer.getMedia().getDuration();
            volumeValue = mediaPlayer.getVolume();

            mediaHeight = media.getHeight();
            mediaWidth = media.getWidth();

            //设置布局尺寸
            setSize(width,height);


            if (scene!= null) {
                scene.widthProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        setSize(newValue.intValue(),currentHeight);}
                });
                scene.heightProperty().addListener(new ChangeListener<Number>() {
                    @Override
                    public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                        setSize(currentWidth,newValue.intValue());
                    }
                });
            }
            EventHandler onScreen = new EventHandler<InputEvent>(){
                @Override
                public void handle(InputEvent event) {
                    controlBar.setVisible(true);
                }
            };
            EventHandler offScreen = new EventHandler<InputEvent>(){
                @Override
                public void handle(InputEvent event) {
                    controlBar.setVisible(false);
                }
            };
            if(scene != null && popup){
                ((Stage)scene.getWindow()).fullScreenProperty().addListener(new ChangeListener<Boolean>() {
                    @Override
                    public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                        if (newValue.booleanValue()) {
                            controlBar.setVisible(false);
                            mediaPane.addEventHandler(MouseEvent.MOUSE_CLICKED, onScreen);
                            controlBar.addEventHandler(MouseEvent.MOUSE_EXITED, offScreen);
                        }else{
                            controlBar.setVisible(true);
                            mediaPane.removeEventHandler(MouseEvent.MOUSE_CLICKED,onScreen);
                            controlBar.removeEventHandler(MouseEvent.MOUSE_EXITED,offScreen);
                        }
                    }
                });
            }

            updateValues();


        });
        mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>(){
            @Override
            public void changed(ObservableValue<? extends Duration> observable, Duration oldValue, Duration newValue) {
                updateValues();
            }
        });
    }

    private void setMediaViewOnClick(){
        mediaView.setOnMouseClicked(event -> {
            if(media == null)
                return;
            MediaPlayer.Status status = mediaPlayer.getStatus();
            if(status == MediaPlayer.Status.UNKNOWN || status == MediaPlayer.Status.HALTED ){
                return;
            }

            if(status == MediaPlayer.Status.PAUSED || status == MediaPlayer.Status.READY || status == MediaPlayer.Status.STOPPED){

                if(atEndOfMedia){
                    mediaPlayer.seek(mediaPlayer.getStartTime());
                    atEndOfMedia = false;
                }
                mediaPlayer.play();
                setIcon(playBT,pauseIcon,25);
            }else{
                mediaPlayer.pause();
                setIcon(playBT,playIcon,25);
            }
        });
    }

    private void setPlayButton(){
        playBT.setOnAction((ActionEvent e)->{
            if(media == null)
                return;
            MediaPlayer.Status status = mediaPlayer.getStatus();
            if(status == MediaPlayer.Status.UNKNOWN || status == MediaPlayer.Status.HALTED ){
                return;
            }

            if(status == MediaPlayer.Status.PAUSED || status == MediaPlayer.Status.READY || status == MediaPlayer.Status.STOPPED){

                if(atEndOfMedia){
                    mediaPlayer.seek(mediaPlayer.getStartTime());
                    atEndOfMedia = false;
                }
                mediaPlayer.play();
                setIcon(playBT,pauseIcon,25);
            }else{
                mediaPlayer.pause();
                setIcon(playBT,playIcon,25);
            }
        });
    }


    private void setStopButton(){
        stopBT.setOnAction((ActionEvent e )->{
            if(media == null)
                return;
            mediaPlayer.stop();
            setIcon(playBT,playIcon,25);
        } );
    }

    private void setProcessSlider(){
        processSD.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(processSD.isValueChanging()){     //加入Slider正在改变的判定，否则由于update线程的存在，mediaPlayer会不停地回绕
                    mediaPlayer.seek(duration.multiply(processSD.getValue()/100.0));
                }
            }
        });
    }



    public void setMaximizeButton(){
        maxBT.setOnAction((ActionEvent e)->{
            if(popup){
                ((Stage)scene.getWindow()).setFullScreen(true);
            }else{
                mediaPlayer.pause();
                setIcon(playBT,pauseIcon,25);
                VideoPlayer player = VideoPlayer.popup(url);
                player.getController().getMediaPlayer().seek(this.mediaPlayer.getCurrentTime());
            }
        });
    }



    private void setVolumeButton(){
        volumeBT.setOnAction((ActionEvent e)->{
            if(media == null)
                return;

            if(mediaPlayer.getVolume()>0){
                volumeValue = mediaPlayer.getVolume();
                volumeSD.setValue(0);
                setIcon(volumeBT,volOffIcon,25);
            }else{
                mediaPlayer.setVolume(volumeValue);
                volumeSD.setValue(volumeValue * 100);
                setIcon(volumeBT,volOnIcon,15);
            }
        });
    }


    private void setVolumeSD(){
        volumeSD.valueProperty().addListener(new ChangeListener<Number>(){
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                mediaPlayer.setVolume(newValue.doubleValue()/100);
            }
        });
    }


    protected void updateValues(){
        if(processSD != null && timeLB!=null && volumeSD != null && volumeBT != null){
            Platform.runLater(() -> {
                Duration currentTime = mediaPlayer.getCurrentTime();
                timeLB.setText(formatTime(currentTime,duration));    //设置时间标签
                processSD.setDisable(duration.isUnknown());   //无法读取时间是隐藏进度条
                if(!processSD.isDisabled() && duration.greaterThan(Duration.ZERO) && !processSD.isValueChanging()){
                    processSD.setValue(currentTime.toMillis()/duration.toMillis() * 100);
                }
                if(!volumeSD.isValueChanging()){
                    volumeSD.setValue((int)Math.round(mediaPlayer.getVolume() *100));
                    if(mediaPlayer.getVolume() == 0){
                        setIcon(volumeBT,volOffIcon,20);
                    }else{
                        setIcon(volumeBT,volOnIcon,20);
                    }
                }
            });
        }
    }

    protected String formatTime(Duration elapsed,Duration duration){

        int intElapsed = (int)Math.floor(elapsed.toSeconds());
        int elapsedHours = intElapsed / (60 * 60);
        int elapsedMinutes = (intElapsed - elapsedHours *60 *60)/ 60;
        int elapsedSeconds = intElapsed - elapsedHours * 60 * 60 - elapsedMinutes * 60;
        if(duration.greaterThan(Duration.ZERO)){
            int intDuration = (int)Math.floor(duration.toSeconds());
            int durationHours = intDuration / (60 * 60);
            int durationMinutes = (intDuration - durationHours *60 * 60) / 60;
            int durationSeconds = intDuration - durationHours * 60 * 60 - durationMinutes * 60;

            if(durationHours > 0){
                return String.format("%02d:%02d:%02d / %02d:%02d:%02d",elapsedHours,elapsedMinutes,elapsedSeconds,durationHours,durationMinutes,durationSeconds);
            }else{
                return String.format("%02d:%02d / %02d:%02d",elapsedMinutes,elapsedSeconds,durationMinutes,durationSeconds);
            }
        }else{
            if(elapsedHours > 0){
                return String.format("%02d:%02d:%02d / %02d:%02d:%02d",elapsedHours,elapsedMinutes,elapsedSeconds);
            }else{
                return String.format("%02d:%02d / %02d:%02d",elapsedMinutes,elapsedSeconds);
            }
        }
    }


    private void setIcon(Button button,String path,int size){
        Image icon = new Image(path);
        ImageView imageView = new ImageView(icon);
        imageView.setFitWidth(size);
        imageView.setFitHeight((int)(size * icon.getHeight() / icon.getWidth()));
        button.setGraphic(imageView);
        ColorAdjust colorAdjust = new ColorAdjust();
        button.setOnMousePressed(event ->  {
            colorAdjust.setBrightness(0.5);
            button.setEffect(colorAdjust);
        });
        button.setOnMouseReleased(event -> {
            colorAdjust.setBrightness(0);
            button.setEffect(colorAdjust);
        });
    }

    public MediaPlayer getMediaPlayer(){
        return this.mediaPlayer;
    }


   public void destroy(){
       if(mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING){
           mediaPlayer.stop();
       }
       mediaPlayer.dispose();
       media = null;
       mediaPlayer = null;
       System.gc();

   }

    public void setSize(int width,int height){
        currentWidth = width;
        currentHeight  = height;
        setUISuitable();

    }

    private void setUISuitable(){
        anchorPane.setPrefSize(currentWidth,currentHeight);
        anchorPane.setBottomAnchor(controlBar, 0.0);
        anchorPane.setTopAnchor(mediaPane,((double)currentHeight  - (double)currentWidth *(double)mediaHeight / (double)mediaWidth - 50)/2);  //设置视频面板位置
        mediaView.setFitWidth(currentWidth);
        mediaView.setFitHeight((double)currentWidth*(double)mediaHeight / (double)mediaHeight);
        controlBar.setPrefWidth(currentWidth);


    }

    public boolean getPopup(){
        return this.popup;
    }


}
