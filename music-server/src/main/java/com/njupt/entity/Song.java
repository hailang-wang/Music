package com.njupt.entity;

import java.util.Date;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/05/20:46
 * @Description:
 */
public class Song {
    private Integer id;
    private Integer singer;
    private String name;
    private String introduction;
    private Date create;
    private Date update;
    private String pic;
    private String lyric;
    private String url;

    public Song() {
    }

    public Song(Integer id, Integer singer, String name, String introduction, Date create, Date update, String pic, String lyric, String url) {
        this.id = id;
        this.singer = singer;
        this.name = name;
        this.introduction = introduction;
        this.create = create;
        this.update = update;
        this.pic = pic;
        this.lyric = lyric;
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSinger() {
        return singer;
    }

    public void setSinger(Integer singer) {
        this.singer = singer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Date getUpdate() {
        return update;
    }

    public void setUpdate(Date update) {
        this.update = update;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id=" + id +
                ", singer=" + singer +
                ", name='" + name + '\'' +
                ", introduction='" + introduction + '\'' +
                ", create=" + create +
                ", update=" + update +
                ", pic='" + pic + '\'' +
                ", lyric='" + lyric + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
