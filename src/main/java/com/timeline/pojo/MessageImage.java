package com.timeline.pojo;

import javax.persistence.*;

@Table(name = "message_image")
public class MessageImage {
    @Id
    private Integer id;

    /**
     * 图片所在的消息id
     */
    private Integer mid;

	private String path;
    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取图片所在的消息id
     *
     * @return mid - 图片所在的消息id
     */
    public Integer getMid() {
        return mid;
    }

    /**
     * 设置图片所在的消息id
     *
     * @param mid 图片所在的消息id
     */
    public void setMid(Integer mid) {
        this.mid = mid;
    }
    public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}