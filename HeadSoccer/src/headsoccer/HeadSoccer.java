/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package headsoccer;

import java.awt.Graphics;
import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.canvas.Canvas;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Kobe Douglas
 */
public class HeadSoccer extends Application {

    /**
     * @param args the command line arguments
     */
    //WIDTH = 1000, HEIGHT = 600 is normal
    private static int WIDTH = 1000, HEIGHT = 600;
    private static Canvas canvas;
    private int tickSpeed, tickSpeed2;
    private int printSpeed, delayTime = 0, powerTimeBall = 0, powerTimeGoalL = 0, powerTimeGoalR = 0, powerTimePlayerL = 0, powerTimePlayerR = 0, powerAddTime = 0, winTime = 0;
    private int whichPower;
    private int textSize;
    private Wall leftWall, rightWall, ceiling, floor;
    private Goal goalL, goalR;
    private DoIt di;

    /**
     *
     */
    public SoccerPlayer leftP,

    /**
     *
     */
    rightP;
    private Ball ball;
    private BigBall bBall;
    private SmallBall sBall;
    private SmallGoal sGoalL, sGoalR;
    private BigGoal bGoalL, bGoalR;
    private BigPlayer bPlayerL, bPlayerR;
    private SmallPlayer sPlayerL, sPlayerR;
    private double gravityUp, gravityDown;
    private double playerSize;
    private int rScore = 0, lScore = 0, winningScore = 1;
    private boolean rWin = false, lWin = false;
    private Image pdesert, thomas, bill, ballin, shrekL, shrekR, bttfL, bttfR, herman, mark,
            markface, steve, desert, bob, forest, pinkT, oldShoe, stadium, dragonLoreR, gabeNTile, gabe,
            blueBlack, bol, bigBall, goal, bigGoal, smallGoal, creed, smallBall, bigPlayer, smallPlayer;
    private ArrayList<PowerUps> change = new ArrayList<>();
    private MainMenu mainMenu;
    private PauseMenu pauseMenu;
    private PlayerPicker playerPicker;
    private PlayerSelection playerOne, playerTwo;
    private StackPane root;
    private boolean paused = false;

    /**
     *
     * @param w is the width of the canvas
     */
    public void setWidth(int w) {
        WIDTH = w;
    }

    /**
     *
     * @param h is the height of the canvas
     */
    public void setHeight(int h) {
        HEIGHT = h;
    }

    /**
     *
     * @return the width of the canvas
     */
    public static int getWidth() {
        return WIDTH;
    }

    /**
     *
     * @return the height of the canvas
     */
    public static int getHeight() {
        return HEIGHT;
    }

    RedrawTimer timer = new RedrawTimer();

    private void addPlayButtonEvent() {
        mainMenu.getPlayButton().setOnAction((ActionEvent event) -> {
            if (!pauseMenu.getResumeAdded()){
                pauseMenu.addResumeButtonBack();
            }
            mainMenu.close(root);
            reset();
            di.open(root);
        });
    }

    private void addPlayerPickerButtonEvent() {
        mainMenu.getPlayerSelectionButton().setOnAction((ActionEvent event) -> {
            mainMenu.close(root);
            playerPicker.open(root);
        });
    }

    private void addPlayerOneButtonEvent() {
        playerPicker.getPlayerOneButton().setOnAction((ActionEvent event) -> {
            playerPicker.close(root);
            playerOne.open(root);
        });
    }

    private void addPlayerTwoButtonEvent() {
        playerPicker.getPlayerTwoButton().setOnAction((ActionEvent event) -> {
            playerPicker.close(root);
            playerTwo.open(root);
        });
    }

    private void addBackButtonEvent() {
        playerPicker.getBackButton().setOnAction((ActionEvent event) -> {
            playerPicker.close(root);
            mainMenu.open(root);
        });
        playerOne.getBackButton().setOnAction((ActionEvent event) -> {
            playerOne.close(root);
            playerPicker.open(root);
        });
        playerTwo.getBackButton().setOnAction((ActionEvent event) -> {
            playerTwo.close(root);
            playerPicker.open(root);
        });
    }

    private void addPlayerImagesButtonEvent() {
        playerTwo.getHermanButton().setOnAction((ActionEvent event) -> {
            rightP.setImage(herman);
        });
        playerOne.getHermanButton().setOnAction((ActionEvent event) -> {
            leftP.setImage(herman);
        });
        playerTwo.getBillButton().setOnAction((ActionEvent event) -> {
            rightP.setImage(bill);
        });
        playerOne.getBillButton().setOnAction((ActionEvent event) -> {
            leftP.setImage(bill);
        });
        playerTwo.getMarkButton().setOnAction((ActionEvent event) -> {
            rightP.setImage(mark);
        });
        playerOne.getMarkButton().setOnAction((ActionEvent event) -> {
            leftP.setImage(mark);
        });
        playerTwo.getThomasButton().setOnAction((ActionEvent event) -> {
            rightP.setImage(thomas);
        });
        playerOne.getThomasButton().setOnAction((ActionEvent event) -> {
            leftP.setImage(thomas);
        });
        playerOne.getSteveButton().setOnAction((ActionEvent event) -> {
            leftP.setImage(steve);
        });
        playerTwo.getSteveButton().setOnAction((ActionEvent event) -> {
            rightP.setImage(steve);
        });
    }

    private void addPlayerSideColorButtonEvent() {
        playerOne.getAquaButton().setOnAction((ActionEvent event) -> {
            goalL.setSideColor(Color.AQUA);
        });
        playerOne.getMediumPurpleButton().setOnAction((ActionEvent event) -> {
            goalL.setSideColor(Color.MEDIUMPURPLE);
        });
        playerOne.getRedButton().setOnAction((ActionEvent event) -> {
            goalL.setSideColor(Color.RED);
        });
        playerOne.getOrangeButton().setOnAction((ActionEvent event) -> {
            goalL.setSideColor(Color.ORANGE);
        });
        playerOne.getGreenButton().setOnAction((ActionEvent event) -> {
            goalL.setSideColor(Color.GREEN);
        });
        playerOne.getBlueButton().setOnAction((ActionEvent event) -> {
            goalL.setSideColor(Color.BLUE);
        });
        playerTwo.getAquaButton().setOnAction((ActionEvent event) -> {
            goalR.setSideColor(Color.AQUA);
        });
        playerTwo.getMediumPurpleButton().setOnAction((ActionEvent event) -> {
            goalR.setSideColor(Color.MEDIUMPURPLE);
        });
        playerTwo.getRedButton().setOnAction((ActionEvent event) -> {
            goalR.setSideColor(Color.RED);
        });
        playerTwo.getOrangeButton().setOnAction((ActionEvent event) -> {
            goalR.setSideColor(Color.ORANGE);
        });
        playerTwo.getGreenButton().setOnAction((ActionEvent event) -> {
            goalR.setSideColor(Color.GREEN);
        });
        playerTwo.getBlueButton().setOnAction((ActionEvent event) -> {
            goalR.setSideColor(Color.BLUE);
        });
    }

    private void addPauseButtonEvent() {
        di.getPauseButton().setOnAction((ActionEvent event) -> {
            if (lWin || rWin){
                pauseMenu.removeResumeButton();
            }
            pauseMenu.open(root);
            paused = true;
        });
    }

    private void addPauseMenuButtonEvent() {
        pauseMenu.getResumeButton().setOnAction((ActionEvent event) -> {
            pauseMenu.close(root);
            paused = false;
        });
        pauseMenu.getRestartButton().setOnAction((ActionEvent event) -> {
            if (!pauseMenu.getResumeAdded()){
                pauseMenu.addResumeButtonBack();
            }
            pauseMenu.close(root);
            paused = false;
            lWin = false;
            rWin = false;
            reset();
            rScore = 0;
            lScore = 0;
        });
        pauseMenu.getMainMenuButton().setOnAction((ActionEvent event) -> {
            pauseMenu.close(root);
            paused = false;
            lWin = false;
            rWin = false;
            reset();
            rScore = 0;
            lScore = 0;
            di.close(root);
            mainMenu.open(root);
        });
    }

    /**
     *
     * @param primaryStage is the primary window in which everything is in
     * @throws Exception
     */
    public void start(Stage primaryStage) throws Exception {
        //players
        thomas = new Image("thomas.jpg");
        bill = new Image("bill2.jpg");
        herman = new Image("herman2.jpg");
        mark = new Image("mark150.jpg");
        markface = new Image("mark2.jpg");
        steve = new Image("steve.png");
        bob = new Image("bob.png");
        creed = new Image("creed.jpg");

        canvas = new Canvas(WIDTH, HEIGHT);
        di = new DoIt(canvas);
        root = new StackPane();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        scene.getStylesheets().add("StyleSheet.css");
        mainMenu = new MainMenu();
        pauseMenu = new PauseMenu();
        playerPicker = new PlayerPicker();
        playerOne = new PlayerSelection();
        playerTwo = new PlayerSelection();
        mainMenu.open(root);
        addPlayButtonEvent();
        addPlayerPickerButtonEvent();
        addPlayerOneButtonEvent();
        addPlayerTwoButtonEvent();
        addBackButtonEvent();
        addPlayerImagesButtonEvent();
        addPlayerSideColorButtonEvent();
        addPauseButtonEvent();
        addPauseMenuButtonEvent();
        //backgrounds
        pdesert = new Image("purple desert.jpg");
        desert = new Image("desert.jpg");
        forest = new Image("forest.jpg");
        pinkT = new Image("pinktree.jpg");
        stadium = new Image("stadium.jpg");

        //shoes
        shrekL = new Image("ShrekShoeL.png");
        shrekR = new Image("ShrekShoe.png");
        bttfL = new Image("bttfshoeL.png");
        bttfR = new Image("bttfshoe.png");
        oldShoe = new Image("OldShoe.jpg");
        dragonLoreR = new Image("dragonLoreShoe.png");

        //powerUps and ball
        smallGoal = new Image("GoalVsmall.png");
        bigGoal = new Image("GoalV.png");
        bigBall = new Image("TheBall.png");
        smallBall = new Image("SmallTheBall.png");
        bigPlayer = new Image("UpArrow.png");
        smallPlayer = new Image("DownArrow.png");
        ballin = new Image("rlball2.png");

        //Miscellaneous
        gabeNTile = new Image("GabeNTile2.jpg");
        gabe = new Image("GabeNewell.jpg");
        blueBlack = new Image("blueBlack.jpg");

        primaryStage.setTitle("HeadSoccer");
        primaryStage.setScene(scene);
        primaryStage.show();
        timer.start();

        //walls
        floor = new Wall(-400, HEIGHT - 20, WIDTH + 800, 420, "bottom");
        leftWall = new Wall(-400, 0, 400, HEIGHT, "left");
        rightWall = new Wall(WIDTH, 0, 400, HEIGHT, "right");
        ceiling = new Wall(-400, -400, WIDTH + 800, 400, "top");

        //players
        playerSize = HEIGHT * ((double) 7 / 60);
        leftP = new SoccerPlayer(WIDTH / 10 + 50, floor.getY() - playerSize, playerSize, playerSize, bill, shrekL, Color.AQUA, "left");
        rightP = new SoccerPlayer(WIDTH - (WIDTH / 10) - 50 - playerSize, floor.getY() - playerSize, playerSize, playerSize, herman, dragonLoreR, Color.MEDIUMPURPLE, "right");

        //ball
        ball = new Ball(WIDTH / 2 - 6, HEIGHT / 2 - 6, HEIGHT / 60, bigBall);

        //goals
        goalL = new Goal(0, HEIGHT - (HEIGHT / 4), WIDTH / 10, HEIGHT / 4, Color.WHITE, Color.AQUA, "left", WIDTH * 3 / 200);
        goalR = new Goal(WIDTH - (WIDTH / 10), HEIGHT - (HEIGHT / 4), WIDTH / 10, HEIGHT / 4, Color.WHITE, Color.MEDIUMPURPLE, "right", WIDTH * 3 / 200);

        //powerUps
        bBall = new BigBall(WIDTH, HEIGHT, WIDTH / 10, HEIGHT / 4, Color.GOLDENROD, bigBall, playerSize, playerSize);
        sBall = new SmallBall(WIDTH, HEIGHT, WIDTH / 10, HEIGHT / 4, Color.HOTPINK, smallBall, playerSize, playerSize);
        sGoalL = new SmallGoal(WIDTH, HEIGHT, WIDTH / 10, HEIGHT / 4, goalL.getSideColor(), smallGoal, playerSize, playerSize);
        sGoalR = new SmallGoal(WIDTH, HEIGHT, WIDTH / 10, HEIGHT / 4, goalR.getSideColor(), smallGoal, playerSize, playerSize);
        bGoalL = new BigGoal(WIDTH, HEIGHT, WIDTH / 10, HEIGHT / 4, goalL.getSideColor(), bigGoal, playerSize, playerSize);
        bGoalR = new BigGoal(WIDTH, HEIGHT, WIDTH / 10, HEIGHT / 4, goalR.getSideColor(), bigGoal, playerSize, playerSize);
        bPlayerL = new BigPlayer(WIDTH, HEIGHT, WIDTH / 10, HEIGHT / 4, goalL.getSideColor(), bigPlayer, playerSize, playerSize);
        bPlayerR = new BigPlayer(WIDTH, HEIGHT, WIDTH / 10, HEIGHT / 4, goalR.getSideColor(), bigPlayer, playerSize, playerSize);
        sPlayerL = new SmallPlayer(WIDTH, HEIGHT, WIDTH / 10, HEIGHT / 4, goalL.getSideColor(), smallPlayer, playerSize, playerSize);
        sPlayerR = new SmallPlayer(WIDTH, HEIGHT, WIDTH / 10, HEIGHT / 4, goalR.getSideColor(), smallPlayer, playerSize, playerSize);

        //list of powerups
        change.add(sGoalR);
        change.add(sGoalL);
        change.add(bGoalL);
        change.add(bGoalR);
        change.add(bBall);
        change.add(sBall);
        change.add(bPlayerL);
        change.add(bPlayerR);
        change.add(sPlayerL);
        change.add(sPlayerR);

        //adding objects to game state
        di.add(leftP);
        di.add(rightP);
        di.add(leftWall);
        di.add(rightWall);
        di.add(ceiling);
        di.add(floor);
        di.add(ball);
        di.add(goalL.getBar());
        di.add(goalR.getBar());
        di.add(goalL);
        di.add(goalR);
        di.add(leftP.getFoot());
        di.add(rightP.getFoot());

// IN ORDER FOR THE SPEEDS TO RELATE TO WIDTH AND HEIGHT, GRAVITY FOR PLAYERS AND BALL NEED TO ALSO (just need to do ball now)
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                //Left Player controls
                if (event.getCode() == KeyCode.D && leftP.getX() + leftP.getWidth() < WIDTH) {
                    leftP.setXvel(WIDTH / 200);
                }
                if (event.getCode() == KeyCode.A && leftP.getX() > 0) {
                    leftP.setXvel(-WIDTH / 200);
                }
                if (event.getCode() == KeyCode.W) {
                    if ((leftP.getY() + leftP.getHeight() >= floor.getY() - 0.1 || (leftP.colliding(rightP) && leftP.getY() < rightP.getY()))) {
                        leftP.jump(-HEIGHT / 120);
                    }
                    if (leftP.getYvel() <= 1 && leftP.getX() < goalL.getWidth() && leftP.getYcenter() < goalL.getBar().getY() && leftP.getYcenter() > goalL.getBar().getY() - leftP.getR() - 2) {
                        leftP.jump(-HEIGHT / 120);
                    }
                    if (leftP.getYvel() <= 1 && leftP.getX() + leftP.getWidth() > goalR.getX() && leftP.getYcenter() < goalR.getBar().getY() && leftP.getYcenter() > goalR.getBar().getY() - leftP.getR() - 2) {
                        leftP.jump(-HEIGHT / 120);
                    }
                }
                if (event.getCode() == KeyCode.SPACE) {
                    leftP.getFoot().setKicking(true);
                    leftP.getFoot().setXvel(7.5);
                    leftP.getFoot().setYvel(-7.5);
                }

                //Right Player controls
                if (event.getCode() == KeyCode.RIGHT && rightP.getX() + rightP.getWidth() < WIDTH) {
                    rightP.setXvel(WIDTH / 200);
                }
                if (event.getCode() == KeyCode.LEFT && rightP.getX() > 0) {
                    rightP.setXvel(-WIDTH / 200);
                }
                if (event.getCode() == KeyCode.UP) {
                    if ((rightP.getY() + rightP.getHeight() >= floor.getY() - 0.1 || (rightP.colliding(leftP) && rightP.getY() < leftP.getY()))) {
                        rightP.jump(-HEIGHT / 120);
                    }
                    if (rightP.getYvel() <= 1 && rightP.getX() < goalL.getWidth() && rightP.getYcenter() < goalL.getBar().getY() && rightP.getYcenter() > goalL.getBar().getY() - rightP.getR() - 2) {
                        rightP.jump(-HEIGHT / 120);
                    }
                    if (rightP.getYvel() <= 1 && rightP.getX() + rightP.getWidth() > goalR.getX() && rightP.getYcenter() < goalR.getBar().getY() && rightP.getYcenter() > goalR.getBar().getY() - rightP.getR() - 2) {
                        rightP.jump(-HEIGHT / 120);
                    }
                }
                if (event.getCode() == KeyCode.P) {
                    rightP.getFoot().setKicking(true);
                    rightP.getFoot().setXvel(-7.5);
                    rightP.getFoot().setYvel(-7.5);
                }

                //ball control for testing
                if (event.getCode() == KeyCode.Y) {
                    ball.setYvel(-HEIGHT / 60);
                    ball.setXvel(ball.getXvel() * 1.2);
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {
                if (event.getCode() == KeyCode.D) {
                    leftP.setXvel(0);
                }
                if (event.getCode() == KeyCode.A) {
                    leftP.setXvel(0);
                }
                if (event.getCode() == KeyCode.SPACE) {
                    leftP.getFoot().setKicking(false);
                    leftP.getFoot().setXvel(0);
                    leftP.getFoot().setYvel(0);
                }
                if (event.getCode() == KeyCode.P) {
                    rightP.getFoot().setKicking(false);
                    rightP.getFoot().setXvel(0);
                    rightP.getFoot().setYvel(0);
                }
                if (event.getCode() == KeyCode.RIGHT) {
                    rightP.setXvel(0);
                }
                if (event.getCode() == KeyCode.LEFT) {
                    rightP.setXvel(0);
                }
            }
        });
    }

    //reseting everything after a goal is scored

    /**
     *
     */
    public void reset() {
        setWidth((int) root.getWidth());
        setHeight((int) root.getHeight());
        canvas.setWidth(WIDTH);
        canvas.setHeight(HEIGHT);
        playerSize = HEIGHT * ((double) 7 / 60);
        floor.setX(-400);
        floor.setY(HEIGHT - 20);
        floor.setWidth(WIDTH + 800);
        leftWall.setHeight(HEIGHT + 800);
        rightWall.setX(WIDTH);
        rightWall.setHeight(HEIGHT + 800);
        ball.setX(WIDTH / 2 - 6);
        ball.setY(HEIGHT / 2 - 6);
        ball.setR(HEIGHT / 60);
        leftP.setX(WIDTH / 10 + 50);
        leftP.setY(floor.getY() - playerSize);
        leftP.setR(playerSize / 2);
        leftP.getFoot().setR(leftP.getR() / 2);
        
        rightP.setX(WIDTH - (WIDTH / 10) - 50 - playerSize);
        rightP.setY(floor.getY() - playerSize);
        rightP.setR(playerSize / 2);
        rightP.getFoot().setR(rightP.getR() / 2);
        ball.setXvel(0);
        ball.setYvel(0);
        goalL.setX(0);
        goalL.setY(HEIGHT - (HEIGHT / 4));
        goalL.setHeight(HEIGHT / 4);
        goalL.setWidth(WIDTH / 10);
        di.remove(goalL.getBar());
        goalL.setThickness(WIDTH * 3 / 200);
        goalL.setBar(new CrossBar(goalL.getX(), goalL.getY() - goalL.getThickness(), goalL.getWidth(), goalL.getThickness(), goalL.getColor(), goalL.getSideColor()));
        di.add(0, goalL.getBar());
        goalR.setX(WIDTH - (WIDTH / 10));
        goalR.setY(HEIGHT - (HEIGHT / 4));
        goalR.setHeight(HEIGHT / 4);
        goalR.setWidth(WIDTH / 10);
        di.remove(goalR.getBar());
        goalR.setThickness(WIDTH * 3 / 200);
        goalR.setBar(new CrossBar(goalR.getX(), goalR.getY() - goalR.getThickness(), goalR.getWidth(), goalR.getThickness(), goalR.getColor(), goalR.getSideColor()));
        di.add(0, goalR.getBar());
        while (change.size() > 0) {
            di.remove(change.get(0));
            change.remove(0);
        }
        powerTimeBall = 0;
        powerTimeGoalL = 0;
        powerTimeGoalR = 0;
        powerTimePlayerL = 0;
        powerTimePlayerR = 0;
        powerAddTime = 0;
        
        leftP.setColor(goalL.getSideColor());
        rightP.setColor(goalR.getSideColor());
        change.add(bBall);
        change.add(sBall);
        change.add(sGoalL);
        change.add(sGoalR);
        change.add(bGoalL);
        change.add(bGoalR);
        change.add(bPlayerL);
        change.add(bPlayerR);
        change.add(sPlayerL);
        change.add(sPlayerR);
        bGoalL.setColor(goalL.getSideColor());
        sGoalL.setColor(goalL.getSideColor());
        bGoalR.setColor(goalR.getSideColor());
        sGoalR.setColor(goalR.getSideColor());
        bPlayerL.setColor(goalL.getSideColor());
        sPlayerL.setColor(goalL.getSideColor());
        bPlayerR.setColor(goalR.getSideColor());
        sPlayerR.setColor(goalR.getSideColor());
        for (int i = 0; i < change.size(); i++) {
            change.get(i).setR(playerSize / 2);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public class RedrawTimer extends AnimationTimer {

        private long lastUpdate = 0;

        /**
         *
         * @param now is the current time
         */
        public void handle(long now) {
            double t = (now - 0) / 1.0;
            if (now - lastUpdate >= 10_000_000) {

                if (di.getOpen()) {
                    //check for win
                    if (lScore == winningScore) {
                        lWin = true;
                    }
                    if (rScore == winningScore) {
                        rWin = true;
                    }

                    //drawing background and floor
                    GraphicsContext gc = canvas.getGraphicsContext2D();
                    gc.drawImage(stadium, 0, 0, WIDTH, HEIGHT);
                    gc.setFill(Color.BLACK);
                    gc.fillRect(0, floor.getY(), WIDTH, HEIGHT);

                    //do everything unless someone has won
                    textSize = WIDTH / 10;
                    if (!lWin && !rWin) {
                        di.DrawAll(canvas);
                        gc.setStroke(Color.WHITE);
                        gc.setLineWidth(5.5);
                        gc.strokeText(rScore + "-" + lScore, WIDTH / 2 - (WIDTH / 10.87), textSize);
                        gc.setFill(new ImagePattern(blueBlack));
                        gc.setFont(new Font("Verdana", textSize));
                        gc.fillText(rScore + "-" + lScore, WIDTH / 2 - (WIDTH / 10.87), textSize);
                    } else {
                        if (lWin) {
                            winTime++;
                            gc.setFont(new Font("Verdana", textSize));
                            gc.setStroke(Color.WHITE);
                            gc.setLineWidth(5.5);
                            gc.strokeText("Right Player Wins!", WIDTH / 2 - (WIDTH / 2.2222222), HEIGHT - (WIDTH / 10));
                            gc.strokeText(rScore + "-" + lScore, WIDTH / 2 - (WIDTH / 10.87), HEIGHT / 2);
                            gc.setFill(new ImagePattern(blueBlack));
                            gc.fillText("Right Player Wins!", WIDTH / 2 - (WIDTH / 2.2222222), HEIGHT - (WIDTH / 10));
                            gc.fillText(rScore + "-" + lScore, WIDTH / 2 - (WIDTH / 10.87), HEIGHT / 2);
                            if (winTime > 300 && !pauseMenu.getOpen()){
                                pauseMenu.removeResumeButton();
                                pauseMenu.open(root);
                            }

                        } else {
                            winTime++;
                            gc.setStroke(Color.WHITE);
                            gc.setLineWidth(5.5);
                            gc.strokeText("Left Player Wins!", WIDTH / 2 - (WIDTH / 2.38095), HEIGHT - (WIDTH / 10));
                            gc.strokeText(rScore + "-" + lScore, WIDTH / 2 - (WIDTH / 10.87), HEIGHT / 2);
                            gc.setFont(new Font("Verdana", textSize));
                            gc.setFill(new ImagePattern(blueBlack));
                            gc.fillText("Left Player Wins!", WIDTH / 2 - (WIDTH / 2.38095), HEIGHT - (WIDTH / 10));
                            gc.fillText(rScore + "-" + lScore, WIDTH / 2 - (WIDTH / 10.87), HEIGHT / 2);
                            if (winTime > 300 && !pauseMenu.getOpen()){
                                pauseMenu.removeResumeButton();
                                pauseMenu.open(root);
                            }
                        }
                    }
                    if (!ball.getLscored() && !ball.getRscored() && !paused) {
                        di.UpdateAll(canvas);
                        di.CollideAll();
                    } else if (!paused) {
                        if (delayTime < 1) {
                            if (ball.getLscored()) {
                                lScore++;
                            }
                            if (ball.getRscored()) {
                                rScore++;
                            }
                        }
                        delayTime++;

                        //gabe newell for 10 frames
                        if (delayTime > 90 && lScore < winningScore && rScore < winningScore) {
                            gc.drawImage(gabe, 0, 0, WIDTH, HEIGHT);
                        }

                        if (delayTime > 100) {
                            ball.setLscored(false);
                            ball.setRscored(false);
                            reset();
                            delayTime = 0;
                        }
                    }
                    printSpeed++;

                    //debugging tool
                    if (printSpeed >= 80) {
                        //System.out.println("ok");
                        printSpeed = 0;
                    }

                    if (!paused) {
                        // left player gravity
                        if (leftP.getY() + leftP.getHeight() >= floor.getY()) {
                            leftP.setYvel(0);
                            leftP.setY(floor.getY() - leftP.getHeight());
                            tickSpeed = 0;
                        }
                        if (leftP.getYvel() != 0 || leftP.getY() + leftP.getHeight() <= floor.getY()) {
                            if (leftP.colliding(rightP) && (leftP.getY() + leftP.getHeight() >= floor.getY() || rightP.getY() + rightP.getHeight() >= floor.getY())) {
                            } else {
                                tickSpeed++;
                                if (tickSpeed >= 8 - ((leftP.getHeight() - 70) / 15)) {
                                    leftP.setYvel(leftP.getYvel() + 1);
                                    tickSpeed = 0;
                                }
                            }
                        }

                        // right player gravity
                        if (rightP.getY() + rightP.getHeight() >= floor.getY()) {
                            rightP.setYvel(0);
                            rightP.setY(floor.getY() - rightP.getHeight());
                            tickSpeed2 = 0;
                        }
                        if (rightP.getYvel() != 0 || rightP.getY() + rightP.getHeight() <= floor.getY()) {
                            if (rightP.colliding(leftP) && (leftP.getY() + leftP.getHeight() >= floor.getY() || rightP.getY() + rightP.getHeight() >= floor.getY())) {
                            } else {
                                tickSpeed2++;
                                if (tickSpeed2 >= 8 - ((rightP.getHeight() - 70) / 15)) {
                                    rightP.setYvel(rightP.getYvel() + 1);
                                    tickSpeed2 = 0;
                                }
                            }
                        }

                        // ball gravity
                        if (ball.getY() + ball.getHeight() < floor.getY()) {
                            ball.setXvel(ball.getXvel() * .998);
                            if (ball.getYvel() < 0) {
                                ball.setYvel(ball.getYvel() * .95);
                                if (ball.getYvel() > -1 && ball.getYvel() < -.2) {
                                    ball.setYvel(ball.getYvel() * .9);
                                }
                                if (ball.getYvel() >= -.2) {
                                    ball.setYvel(0);
                                }
                            }
                            if (ball.getYvel() > 0 && ball.getYvel() < 3) {
                                ball.setYvel(ball.getYvel() * 1.05);
                            }
                            if (ball.getYvel() >= 3) {
                                ball.setYvel(ball.getYvel() * 1.02);
                            }
                            if (ball.getY() > floor.getY() - playerSize / 2 && Math.abs(ball.getYvel()) < 2.5) {
                                ball.setYvel(ball.getYvel() * .95);
                            }
                            if (ball.getYvel() > -.7 && ball.getYvel() < .6 && ball.getY() + ball.getHeight() >= floor.getY() - 1) {
                                ball.setYvel(0);
                            }
                            if (ball.getY() >= floor.getY() - ball.getHeight() - 1 && ball.getYvel() == 0) {
                                ball.setXvel(ball.getXvel() * .98);
                            }
                            if (ball.getYvel() == 0 && ball.getY() + ball.getHeight() < floor.getY() - 1) {
                                ball.setYvel(.5);
                            }
                        } else {
                            ball.setXvel(ball.getXvel() * .99);
                        }

                        // foot gravity
                        if (leftP.getFoot().getAngle() < Math.PI / 3 && !leftP.getFoot().getKicking()) {
                            leftP.getFoot().setAngle(leftP.getFoot().getAngle() + .1);
                        }
                        if (rightP.getFoot().getAngle() > 2 * Math.PI / 3 && !rightP.getFoot().getKicking()) {
                            rightP.getFoot().setAngle(rightP.getFoot().getAngle() - .1);
                        }

                        // power ups
                        //powerTime is the amount of time the powerUp is actually causing an effect.
                        //powerAddTime is the amount of time before another powerUp is added
                        powerAddTime++;
                        if (powerAddTime > 400) {
                            whichPower = (int) (Math.random() * change.size());
                            change.get(whichPower).randomize(WIDTH, HEIGHT, goalL.getWidth(), goalL.getHeight());
                            di.add(change.get(whichPower));
                            change.get(whichPower).setDisplayTime(0);
                            powerAddTime = 0;
                        }
                        if (change.get(whichPower).getDisplayTime() < 400) {
                            change.get(whichPower).setDisplayTime(change.get(whichPower).getDisplayTime() + 1);
                        } else {
                            di.remove(change.get(whichPower));
                        }

                        //setting the timers for how long the powerups have an effect
                        if (ball.getR() != HEIGHT / 60) {
                            powerTimeBall++;
                            if (powerTimeBall > 400) {
                                ball.setR(HEIGHT / 60);
                                powerTimeBall = 0;
                            }
                        }
                        if (goalL.getY() != HEIGHT - (HEIGHT / 4)) {
                            powerTimeGoalL++;
                            if (powerTimeGoalL > 400) {
                                goalL.setY(HEIGHT - (HEIGHT / 4));
                                goalL.setHeight(HEIGHT / 4);
                                di.remove(goalL.getBar());
                                goalL.setBar(new CrossBar(goalL.getX(), goalL.getY() - goalL.getThickness(), goalL.getWidth(), goalL.getThickness(), goalL.getColor(), goalL.getSideColor()));
                                di.add(0, goalL.getBar());
                            }
                        }
                        if (goalR.getY() != HEIGHT - (HEIGHT / 4)) {
                            powerTimeGoalR++;
                            if (powerTimeGoalR > 400) {
                                goalR.setY(HEIGHT - (HEIGHT / 4));
                                goalR.setHeight(HEIGHT / 4);
                                di.remove(goalR.getBar());
                                goalR.setBar(new CrossBar(goalR.getX(), goalR.getY() - goalR.getThickness(), goalR.getWidth(), goalR.getThickness(), goalR.getColor(), goalR.getSideColor()));
                                di.add(0, goalR.getBar());
                            }
                        }
                        if (leftP.getR() != playerSize / 2) {
                            powerTimePlayerL++;
                            if (powerTimePlayerL > 400) {
                                leftP.setR(playerSize / 2);
                                leftP.getFoot().setR(leftP.getR() / 2);
                            }
                        }
                        if (rightP.getR() != playerSize / 2) {
                            powerTimePlayerR++;
                            if (powerTimePlayerR > 400) {
                                rightP.setR(playerSize / 2);
                                rightP.getFoot().setR(rightP.getR() / 2);
                            }
                        }

                        //if ball collides with powerup, make the powerup take effect
                        for (int i = 0; i < change.size(); i++) {
                            if (change.size() > 0 && change.get(i) instanceof BigBall && change.get(i).getCollide()) {
                                di.remove(change.get(i));
                                ball.setR(HEIGHT / 60 + (HEIGHT / 40));
                                powerTimeBall = 0;
                                change.get(i).setCollide(false);
                                change.get(i).randomize(WIDTH, HEIGHT, goalL.getWidth(), goalL.getHeight());
                            }
                            if (change.size() > 0 && change.get(i) instanceof SmallBall && change.get(i).getCollide()) {
                                di.remove(change.get(i));
                                ball.setR(HEIGHT / 60 - (HEIGHT / 150));
                                powerTimeBall = 0;
                                change.get(i).setCollide(false);
                                change.get(i).randomize(WIDTH, HEIGHT, goalL.getWidth(), goalL.getHeight());
                            }
                            if (change.size() > 0 && change.get(i) instanceof SmallGoal && change.get(i).getCollide() && change.get(i).getColor().equals(goalL.getSideColor())) {
                                di.remove(change.get(i));
                                goalL.setY((HEIGHT - (HEIGHT / 4)) + (HEIGHT / 8));
                                goalL.setHeight(HEIGHT / 8);
                                di.remove(goalL.getBar());
                                goalL.setBar(new CrossBar(goalL.getX(), goalL.getY() - goalL.getThickness(), goalL.getWidth(), goalL.getThickness(), goalL.getColor(), goalL.getSideColor()));
                                di.add(0, goalL.getBar());
                                powerTimeGoalL = 0;
                                change.get(i).setCollide(false);
                                change.get(i).randomize(WIDTH, HEIGHT, goalL.getWidth(), goalL.getHeight());
                            }
                            if (change.size() > 0 && change.get(i) instanceof SmallGoal && change.get(i).getCollide() && change.get(i).getColor().equals(goalR.getSideColor())) {
                                di.remove(change.get(i));
                                goalR.setY((HEIGHT - (HEIGHT / 4)) + (HEIGHT / 8));
                                goalR.setHeight(HEIGHT / 8);
                                di.remove(goalR.getBar());
                                goalR.setBar(new CrossBar(goalR.getX(), goalR.getY() - goalR.getThickness(), goalR.getWidth(), goalR.getThickness(), goalR.getColor(), goalR.getSideColor()));
                                di.add(0, goalR.getBar());
                                powerTimeGoalR = 0;
                                change.get(i).setCollide(false);
                                change.get(i).randomize(WIDTH, HEIGHT, goalL.getWidth(), goalL.getHeight());
                            }
                            if (change.size() > 0 && change.get(i) instanceof BigGoal && change.get(i).getCollide() && change.get(i).getColor().equals(goalL.getSideColor())) {
                                di.remove(change.get(i));
                                goalL.setY((HEIGHT - (HEIGHT / 4)) - (HEIGHT / 8));
                                goalL.setHeight(3 * (HEIGHT / 8));
                                di.remove(goalL.getBar());
                                goalL.setBar(new CrossBar(goalL.getX(), goalL.getY() - goalL.getThickness(), goalL.getWidth(), goalL.getThickness(), goalL.getColor(), goalL.getSideColor()));
                                di.add(0, goalL.getBar());
                                powerTimeGoalL = 0;
                                change.get(i).setCollide(false);
                                change.get(i).randomize(WIDTH, HEIGHT, goalL.getWidth(), goalL.getHeight());
                            }
                            if (change.size() > 0 && change.get(i) instanceof BigGoal && change.get(i).getCollide() && change.get(i).getColor().equals(goalR.getSideColor())) {
                                di.remove(change.get(i));
                                goalR.setY((HEIGHT - (HEIGHT / 4)) - (HEIGHT / 8));
                                goalR.setHeight(3 * (HEIGHT / 8));
                                di.remove(goalR.getBar());
                                goalR.setBar(new CrossBar(goalR.getX(), goalR.getY() - goalR.getThickness(), goalR.getWidth(), goalR.getThickness(), goalR.getColor(), goalR.getSideColor()));
                                di.add(0, goalR.getBar());
                                powerTimeGoalR = 0;
                                change.get(i).setCollide(false);
                                change.get(i).randomize(WIDTH, HEIGHT, goalL.getWidth(), goalL.getHeight());
                            }
                            if (change.size() > 0 && change.get(i) instanceof BigPlayer && change.get(i).getCollide() && change.get(i).getColor().equals(goalL.getSideColor())) {
                                di.remove(change.get(i));
                                leftP.setR(playerSize / 2 + (HEIGHT / 30));
                                leftP.getFoot().setR(leftP.getR() / 2);
                                powerTimePlayerL = 0;
                                change.get(i).setCollide(false);
                                change.get(i).randomize(WIDTH, HEIGHT, goalL.getWidth(), goalL.getHeight());
                            }
                            if (change.size() > 0 && change.get(i) instanceof BigPlayer && change.get(i).getCollide() && change.get(i).getColor().equals(goalR.getSideColor())) {
                                di.remove(change.get(i));
                                rightP.setR(playerSize / 2 + (HEIGHT / 30));
                                rightP.getFoot().setR(rightP.getR() / 2);
                                powerTimePlayerR = 0;
                                change.get(i).setCollide(false);
                                change.get(i).randomize(WIDTH, HEIGHT, goalL.getWidth(), goalL.getHeight());
                            }
                            if (change.size() > 0 && change.get(i) instanceof SmallPlayer && change.get(i).getCollide() && change.get(i).getColor().equals(goalL.getSideColor())) {
                                di.remove(change.get(i));
                                leftP.setR(playerSize / 2 - (HEIGHT / 30));
                                leftP.getFoot().setR(leftP.getR() / 2);
                                powerTimePlayerL = 0;
                                change.get(i).setCollide(false);
                                change.get(i).randomize(WIDTH, HEIGHT, goalL.getWidth(), goalL.getHeight());
                            }
                            if (change.size() > 0 && change.get(i) instanceof SmallPlayer && change.get(i).getCollide() && change.get(i).getColor().equals(goalR.getSideColor())) {
                                di.remove(change.get(i));
                                rightP.setR(playerSize / 2 - (HEIGHT / 30));
                                rightP.getFoot().setR(rightP.getR() / 2);
                                powerTimePlayerR = 0;
                                change.get(i).setCollide(false);
                                change.get(i).randomize(WIDTH, HEIGHT, goalL.getWidth(), goalL.getHeight());
                            }
                        }
                    }
                }
                lastUpdate = now;
            }
        }
    }
}
