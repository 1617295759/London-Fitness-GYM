package team.gym.Beans;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Video {
    private final StringProperty name = new SimpleStringProperty();
    private final StringProperty category = new SimpleStringProperty();
    private final StringProperty intro = new SimpleStringProperty();
    private final StringProperty trainer = new SimpleStringProperty();
    private final String url = "";

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getCategory() {
        return category.get();
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public String getIntro() {
        return intro.get();
    }

    public StringProperty introProperty() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro.set(intro);
    }

    public String getTrainer() {
        return trainer.get();
    }

    public StringProperty trainerProperty() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer.set(trainer);
    }

    public String getUrl() { return url; }
}

