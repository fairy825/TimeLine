package com.timeline.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.timeline.utils.TimeAgoUtils;

public class Message {
    @Id
    private Integer id;

    private String author;

    @Column(name = "create_time")
    private Date createTime;

    private String content;

    @Transient
	private String timeDesc;
    
    @Transient
    List<MessageImage> messageImages;
    
    public void setMessageImages(List<MessageImage> messageImages) {
		this.messageImages = messageImages;
	}

	public List<MessageImage> getMessageImages() {
		return messageImages;
	}
	
	public String getTimeDesc() {
		return TimeAgoUtils.format(createTime);
	}
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
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }
}