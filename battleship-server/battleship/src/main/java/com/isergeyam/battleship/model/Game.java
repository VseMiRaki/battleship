package com.isergeyam.battleship.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import com.isergeyam.battleship.model.User;
import com.isergeyam.battleship.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Game
 */
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Game {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer Id;

  @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="winner_id")
  @NotBlank
  private User winner;

  @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinColumn(name="loser_id")
  @NotBlank
  private User loser;
}