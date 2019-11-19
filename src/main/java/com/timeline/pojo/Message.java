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
    
    public static class MessageBuilder{
    	private Integer id;       
        private String author;
        private Date createTime;
        private String content;

        public MessageBuilder id(Integer id){
            this.id = id;
            return this;
        }

        public MessageBuilder author(String author){
            this.author = author;
            return this;
        }

        public MessageBuilder content(String content){
            this.content = content;
            return this;
        }

        public MessageBuilder createTime(Date createTime){
            this.createTime = createTime;
            return this;
        }

        public Message build(){
            return new Message(author,content,createTime);
        }

    }
    public Message() {
	}


	public Message(String author, String content, Date createTime) {
		this.author = author;
		this.createTime = createTime;
		this.content = content;
	}


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