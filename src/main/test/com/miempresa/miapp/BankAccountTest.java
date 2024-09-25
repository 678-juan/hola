package main.test.com.miempresa.miapp;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import main.java.com.miempresa.miapp.BankAccount;

class BankAccountTest {
	 BankAccount Cuenta;
	
	
	@BeforeEach
	    public void setup() {
	        /*par el deposit y el withdraw **/
	        Cuenta = new BankAccount(100.0);
	    }
	@AfterEach
	void despues() {
		System.out.println("prueba finalizada");
		
	}
	@Test
	
	void testcontructor() {
		double initialBalance=14;
		BankAccount BA= new BankAccount(initialBalance);
		assertEquals(initialBalance,BA.getBalance());
	}
	
	@Test
	void testConstructorException() {
		
		IllegalArgumentException excep= assertThrows(IllegalArgumentException.class,()-> new BankAccount(-3.0));
		assertEquals("Initial balance cannot be negative",excep.getMessage());
	}
	
	@Test
	void testdeposi() {
		Cuenta.deposit(70);
		assertEquals(170,Cuenta.getBalance());
	}
	
	//lo que no sea constructor no se le pone el new sino que se pone la estancia y el metodo a llamar llenandolo con lel numero que se requiera para testear
	
	@Test
	void testExcepciondepo() {
		IllegalArgumentException e= assertThrows(IllegalArgumentException.class,()-> Cuenta.deposit(-30.0));
		assertEquals("Deposit amount must be positive",e.getMessage());
	}
	
	
	
	
	@Test
	void testwitdrawsuficiente() {
		//se le resta al monto total lo que se va a sacr en el withdraw
		Cuenta.withdraw(30.0);
		assertEquals(70.0,Cuenta.getBalance());
		
	}
	@Test
	void testwitdrawExceptioniif1() {
		IllegalArgumentException ex= assertThrows(IllegalArgumentException.class,()-> Cuenta.withdraw(-10));
		assertEquals("Withdrawal amount must be positive",ex.getMessage());
	
	}
	@Test
	void testwitdrawExceptioniif2() {
		IllegalArgumentException exce= assertThrows(IllegalArgumentException.class,()-> Cuenta.withdraw(3000));
		assertEquals("Insufficient funds",exce.getMessage());
	
	}
}


