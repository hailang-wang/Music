package com.njupt.entity;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/07/11:51
 * @Description:
 */
public class SongList {
    private Integer id;
    private String title;
    private String pic;
    private String introduction;
    private String style;

    public SongList() {
    }

    public SongList(Integer id, String title, String pic, String introduction, String style) {
        this.id = id;
        this.title = title;
        this.pic = pic;
        this.introduction = introduction;
        this.style = style;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
