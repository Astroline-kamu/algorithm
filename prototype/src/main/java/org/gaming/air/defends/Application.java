/*
 * Copyright (c) 2023. Astroline All rights reserved.
 *
 * @date: 5/23/23, 10:16 AM
 * @author: Astroline <Astroline_kamu@outlook.com>
 *
 * 在那古老的家族里，她的名字叫Asyrerina，她不记得自己姓什么了，也有可能是那个该死的作者从来没有想过她的姓。不过在现在她生活着的地方，我们叫她亚斯兰娜，这是她的起源。
 *
 * 从那开始，她就想要去构建一些精妙的东西，如同钻石上浮雕啦，冰球里的火焰啦——尽管这些东西看起来都是不可能完成的，但是在她手里，只要她愿意想，不管是什么东西都能被她所构建出来。
 *
 * 在这个世界上，即便是物理学也要让她三分。在这个世界上，她实现的东西如算法一般精美，巧妙。她所谱写的，是这个世界的艺术，最原初的样貌。
 */

package src.main.java.org.gaming.air.defends;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

public class Application {

        private static final int WIDTH = 800;
        private static final int HEIGHT = 600;

        private static long window;

        private static float triangleRotationAngle = 0.0f;
        private static float triangleXPosition = 0.0f;
        private static float triangleYPosition = 0.0f;

        public static void main(String[] args) {
            init();
            loop();
            cleanup();
        }

        private static void init() {
            GLFW.glfwInit();

            GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3);
            GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 3);
            GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE, GLFW.GLFW_OPENGL_CORE_PROFILE);
            GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE);

            window = GLFW.glfwCreateWindow(WIDTH, HEIGHT, "Triangle Demo", 0, 0);
            GLFW.glfwMakeContextCurrent(window);

            GL.createCapabilities();

            GL11.glViewport(0, 0, WIDTH, HEIGHT);

            GL11.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glLoadIdentity();
            GL11.glOrtho(-WIDTH / 2, WIDTH / 2, -HEIGHT / 2, HEIGHT / 2, 1, -1);
        }

        private static void loop() {
            while(!GLFW.glfwWindowShouldClose(window)) {
                GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);

                drawTriangle();

                update();

                GLFW.glfwSwapBuffers(window);
                GLFW.glfwPollEvents();
            }
        }

        private static void drawTriangle() {
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glLoadIdentity();

            GL11.glTranslatef(triangleXPosition, triangleYPosition, 0.0f);
            GL11.glRotatef(triangleRotationAngle, 0.0f, 0.0f, 1.0f);

            GL11.glBegin(GL11.GL_TRIANGLES);
            GL11.glColor3f(1.0f, 0.0f, 0.0f);
            GL11.glVertex3f(0.0f, 50.0f, 0.0f);
            GL11.glColor3f(0.0f, 1.0f, 0.0f);
            GL11.glVertex3f(-50.0f, -50.0f, 0.0f);
            GL11.glColor3f(0.0f, 0.0f, 1.0f);
            GL11.glVertex3f(50.0f, -50.0f, 0.0f);
            GL11.glEnd();
        }

        private static void update() {
            triangleRotationAngle += 1.0f;
            triangleXPosition += 0.5f;
            triangleYPosition += 0.5f;
        }

        private static void cleanup() {
            GLFW.glfwDestroyWindow(window);
            GLFW.glfwTerminate();
        }

    }




