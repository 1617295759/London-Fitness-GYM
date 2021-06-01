package team.gym.Controller;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import team.gym.MainApp;
import team.gym.MyUtils.Session;
import team.gym.MyUtils.VideoPlayer;
import team.gym.View.LoginView;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@FXMLController
public class VideoController {

    @FXML
    private Button videoInrto1;

    @FXML
    private Button videoInrto2;

    @FXML
    private Button videoInrto3;

    @FXML
    private Button videoInrto4;

    @FXML
    private Button videoInrto5;

    @FXML
    private Button videoInrto6;

    @FXML
    private ImageView video1;

    @FXML
    private ImageView video2;

    @FXML
    private ImageView video5;

    @FXML
    private ImageView video6;

    @FXML
    private ImageView video3;

    @FXML
    private ImageView video4;

    @FXML
    private Button membershipButton;

    @FXML
    private Button mineButton;

    @FXML
    private Button exitButton;

    @FXML
    private Button ViewSearchButton;

    @FXML
    private AnchorPane menuPane;

    @FXML
    private Button bookButton;

    @FXML
    private Button movesButton;

    @FXML
    private Button ballButton;

    @FXML
    private Button videoButton;

    @FXML
    private Button yogaButton;

    @FXML
    private Button HIITButton;

    @FXML
    private TextField ViewTF;

    List<ImageView> videoImg = new ArrayList<>();
    List<Button> videoIntro = new ArrayList<>();
    String type = "yoga";

    List<String> yoga = new ArrayList<>(){{
        add("/statics/images/videoImg/Ball Exercise.jpg");
        add("/statics/images/videoImg/Fitness Ball - Train Legs.jpg");
        add("/statics/images/videoImg/Fitness Ball of High Difficulty.jpg");
        add("/statics/images/videoImg/Fitness Ball of Low Difficulty.jpg");
        add("/statics/images/videoImg/Fitness Ball Teaching.jpg");
        add("/statics/images/videoImg/Gym Ball.jpg");
    }};

    List<String> hiit = new ArrayList<>(){{
        add("/statics/images/videoImg/Advanced HIIT Training.jpg");
        add("/statics/images/videoImg/HIIT for Muscle-building.jpg");
        add("/statics/images/videoImg/HIIT for Physical Exercise.jpg");
        add("/statics/images/videoImg/HIIT for reducing fat.jpg");
        add("/statics/images/videoImg/Intermediate HIIT Training.jpg");
        add("/statics/images/videoImg/Primary HIIT.jpg");
    }};

    List<String> power = new ArrayList<>(){{
        add("/statics/images/videoImg/Boxing Teaching.jpg");
        add("/statics/images/videoImg/Functional Strength Training.jpg");
        add("/statics/images/videoImg/build Peach Buttock.jpg");
        add("/statics/images/videoImg/Bench Press.jpg");
        add("/statics/images/videoImg/Waist Strength Training.jpg");
        add("/statics/images/videoImg/Weightlifting Teaching.jpg");
    }};

    List<String> ball = new ArrayList<>(){{
        add("/statics/images/videoImg/Basic Yoga Teaching.jpg");
        add("/statics/images/videoImg/Classical Yoga Teaching.jpg");
        add("/statics/images/videoImg/Indian Yoga.jpg");
        add("/statics/images/videoImg/Modern Yoga Teaching.jpg");
        add("/statics/images/videoImg/Yoga for Middle-aged and Elderly.jpg");
        add("/statics/images/videoImg/Yoga of High Difficulty.jpg");
    }};

    @FXML
    private void initialize() {
        videoImg.add(video1);
        videoImg.add(video2);
        videoImg.add(video3);
        videoImg.add(video4);
        videoImg.add(video5);
        videoImg.add(video6);

        videoIntro.add(videoInrto1);
        videoIntro.add(videoInrto2);
        videoIntro.add(videoInrto3);
        videoIntro.add(videoInrto4);
        videoIntro.add(videoInrto5);
        videoIntro.add(videoInrto6);

        for (ImageView image:videoImg) {
            image.setFitWidth(220);
            image.setFitHeight(150);
        }
        for (Button button:videoIntro){
            button.setAlignment(Pos.BOTTOM_LEFT);
            button.setLayoutY(150);
            button.setPrefHeight(50);
            button.setMinWidth(220);
            button.setFont(new Font(18));
        }
        show(yoga);
    }

    @FXML
    void searchVideo(ActionEvent event) {
        String search = ViewTF.getText();
        switch (search){
            case "yoga" -> {
                show(yoga);type="yoga";
            }
            case "hiit" -> {
                show(hiit);type="hiit";
            }
            case "power" -> {
                show(power);type="power";
            }
            case "ball" -> {
                show(ball);type="ball";
            }
            default -> {
                show(yoga);type = "yoga";
            }
        }
    }

    @FXML
    void mineEvent(ActionEvent event) { MainApp.showView(team.gym.View.MineView.class); }

    @FXML
    void videoEvent(ActionEvent event) { MainApp.showView(team.gym.View.Video.class); }

    @FXML
    void bookEvent(ActionEvent event) {
        MainApp.showView(team.gym.View.Book.class);
    }

    @FXML
    void membershipEvent(ActionEvent event) {
        MainApp.showView(team.gym.View.Membership.class);
    }

    @FXML
    void exitEvent(ActionEvent event) {
        MainApp.showView(LoginView.class);
        Session.setUser(null);
    }

    @FXML
    void yogaEvent(MouseEvent event) {
        show(yoga);
        type = "yoga";
    }
    @FXML
    void HIITEvent(MouseEvent event) {
        show(hiit);
        type = "hiit";
    }


    @FXML
    void powerEvent (MouseEvent event) {
        show(power);
        type = "power";
    }
    @FXML
    void ballsEvent(MouseEvent event) {
        show(ball);
        type = "ball";
    }

    @FXML
    void video1Play(MouseEvent event) {
        String videoPath = switch (type) {
            case "yoga" ->  "/statics/videos/TestMedia.MP4" ;
            case "hiit" ->  "/statics/videos/TestMedia.MP4" ;
            case "power" ->  "/statics/videos/TestMedia.MP4";
            case "ball" -> "/statics/videos/TestMedia.MP4";
            default ->  "/statics/videos/TestMedia.MP4" ;
        };
        VideoPlayer.popup(getClass().getResource(videoPath).toString());
    }

    Image handleimage(String path){
        Image image = new Image(path);
        return image;
    }
    String handleNameFromPath(String path){
        return path.substring(25,path.length()-4);
    }

    private void show(List<String> type) {
        for (int i = 0;i<videoImg.size();i++){
            videoImg.get(i).setImage(handleimage(type.get(i)));
        }
        for (int i = 0;i<videoIntro.size();i++){
            videoIntro.get(i).setText(handleNameFromPath(type.get(i)));
        }
    }

}
