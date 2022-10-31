package com.example.musicez.model;

import javax.persistence.*;

@Entity
@Table(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String product;
    private String producer;
    private String style;
    private String link;

    public Music() {
    }

    public Music(Long id, String product, String producer, String style, String link) {
        this.id = id;
        this.product = product;
        this.producer = producer;
        this.style = style;
        this.link = link;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "Music{" +
                "id=" + id +
                ", product='" + product + '\'' +
                ", producer='" + producer + '\'' +
                ", style='" + style + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
