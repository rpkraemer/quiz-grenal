package org.devinpf.controller;

import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.devinpf.model.Fan;
import org.devinpf.model.Team;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.vraptor.Result;

public class WelcomeFanControllerTest {
	
	private static final String NULL_NAME = null;
	private static final String EMPTY_NAME = "";
	
	private WelcomeFanController controller;
	private Result resultMock;
	
	@Before
	public void setUp() {
		resultMock = mock(Result.class);
		controller = new WelcomeFanController(resultMock);
	}
	
	@Test
	public void shouldWelcomeAColoradoFan() {
		shouldWelcomeAFan(Team.Internacional);
	}
	
	@Test
	public void shouldWelcomeAGremistaFan() {
		shouldWelcomeAFan(Team.Gremio);
	}
	@Test
	public void shouldNotWelcomeAColoradoFanWithNameNotInfomed() {
		shouldNotWelcomeAFanWithNameNotInfomed(Team.Internacional);
	}
	
	@Test
	public void shouldNotWelcomeAGremistaFanWithNameNotInfomed() {
		shouldNotWelcomeAFanWithNameNotInfomed(Team.Gremio);
	}

	@Test
	public void shoulNotWelcomeAColoradoWithEmptyName(){
		shouldNotWelcomeAFanWithEmptyName(Team.Internacional);
	}
	
	@Test
	public void shoulNotWelcomeAGremistaWithEmptyName(){
		shouldNotWelcomeAFanWithEmptyName(Team.Gremio);
	}
	
	private void shouldWelcomeAFan(Team team) {
		Fan fan = givenAFan("João Ninguém", team);
		controller.welcome(fan);
		verify(resultMock).include("welcome", "Olá João Ninguém");
		verify(resultMock).include("fan", fan);
	}
	
	private void shouldNotWelcomeAFanWithNameNotInfomed(Team team) {
		Fan fan = givenAFan(NULL_NAME, team);
		controller.welcome(fan);
		verify(resultMock, only()).include(eq("error"), anyString());
	}
	
	private void shouldNotWelcomeAFanWithEmptyName(Team team) {
		Fan fan = givenAFan(EMPTY_NAME, team);
		controller.welcome(fan);
		verify(resultMock, only()).include(eq("error"), anyString());
	}

	private Fan givenAFan(String name, Team team) {
		return new Fan(name).setTeam(team);
	}

}