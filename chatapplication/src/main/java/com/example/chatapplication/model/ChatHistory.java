package com.example.chatapplication.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tbl_chat_history")
public class ChatHistory {

    @Id
    @Column(name = "chat_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer chatId;

    @JoinColumn(name = "to_user_id")
    @ManyToOne
    private Users to;

    @JoinColumn(name = "from_user_id")
    @ManyToOne
    private Users from;

    @Column(name = "message")
    private String message;

   
    @CreationTimestamp
    @Column(nullable = false,updatable = false, name = "created_date")
    private Timestamp createdDate;
     
    @UpdateTimestamp
    @Column(name = "updated_date")
    private Timestamp updatedDate;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status statusId;
}