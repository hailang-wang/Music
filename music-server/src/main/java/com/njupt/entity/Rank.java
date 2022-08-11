package com.njupt.entity;

/**
 * Creat with IntelliJ IDEA
 *
 * @Auther:倔强的加瓦
 * @Date:2021/12/09/16:14
 * @Description:
 */
public class Rank {
    private Integer id;
    private Integer songListId;
    private Integer consumerId;
    private Integer score;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSongListId() {
        return songListId;
    }

    public void setSongListId(Integer songListId) {
        this.songListId = songListId;
    }

    public Integer getConsumerId() {
        return consumerId;
    }

    public void setConsumerId(Integer consumerId) {
        this.consumerId = consumerId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Rank() {
    }

    public Rank(Integer id, Integer songListId, Integer consumerId, Integer score) {
        this.id = id;
        this.songListId = songListId;
        this.consumerId = consumerId;
        this.score = score;
    }
}
