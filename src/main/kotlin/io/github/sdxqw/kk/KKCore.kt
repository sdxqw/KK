package io.github.sdxqw.kk

import org.lwjgl.glfw.GLFW.*
import org.lwjgl.opengl.GL.createCapabilities
import org.lwjgl.opengl.GL11.*
import org.lwjgl.system.MemoryUtil.NULL

class KKCore {

    private val width: Int = 1280
    private val height: Int = 720
    private var window: Long? = null
    private var running: Boolean? = null

    fun startGame() {
        initGame()
        while (running!!) {
            renderGame()
            updateGame()
            stopGame()
        }
    }

    private fun initGame() {
        this.running = true

        if (glfwInit()) println("error initializing")

        glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE)

        window = glfwCreateWindow(width, height, "KK Game", NULL, NULL)

        if (window == NULL) throw RuntimeException("Failed to create the GLFW window")

        glfwMakeContextCurrent(window!!)

        glfwShowWindow(window!!)

        createCapabilities()
    }

    private fun renderGame() {
        glClear(GL_COLOR_BUFFER_BIT or GL_DEPTH_BUFFER_BIT)
        glClearColor(1.0f, 0.0f, 0.0f, 0.0f)
        glfwSwapBuffers(window!!)
    }

    private fun updateGame() {
        glfwPollEvents()
    }

    private fun stopGame() {
        if (glfwWindowShouldClose(window!!)) running = false
    }
}