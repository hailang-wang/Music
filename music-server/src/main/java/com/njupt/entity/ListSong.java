package com.njupt.entity;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/07/14:11
 * @Description:
 */
public class ListSong {
    private Integer id;
    private Integer songId;
    private Integer songListId;

    public ListSong() {
    }

    public ListSong(Integer id, Integer songId, Integer songListId) {
        this.id = id;
        this.songId = songId;
        this.songListId = songListId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSongId() {
        return songId;
    }

    public void setSongId(Integer songId) {
        this.songId = songId;
    }

    public Integer getSongListId() {
        return songListId;
    }

    public void setSongListId(Integer songListId) {
        this.songListId = songListId;
    }

    @Override
    public String toString() {
        return "ListSong{" +
                "id=" + id +
                ", songId=" + songId +
                ", songListId=" + songListId +
                '}';
    }
}
