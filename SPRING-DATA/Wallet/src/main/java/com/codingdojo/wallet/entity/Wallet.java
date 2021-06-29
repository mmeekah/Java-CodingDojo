package com.codingdojo.wallet.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Wallet {
	@Setter
	@Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//   @NotBlank(message = "Name cann't be blank")
	@Setter
	@Getter
    @Size(min = 2,max = 30)
    private String name;
    @Size(max = 30)
    private String accountNumber;
    @Size(max = 100)
    private String description;
    @Min(1)
    @Max(3)
    private Integer priority; //1=High; 2=Medium; 3=Low
    private Double currentBalance;
    @OneToMany(cascade = CascadeType.REFRESH,fetch = FetchType.LAZY,mappedBy = "wallet",orphanRemoval = true)
    @JsonIgnore
    private List<Transaction> transactions;
    @PrePersist
    public void setBalance(){ this.currentBalance = new Double(0); }
	public Object getId() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}
	
  
}