#!/usr/bin/env kotlin

@file:DependsOn("com.hexagonkt:http_server_netty:3.5.3")
@file:DependsOn("com.github.mouse0w0:darculafx:9.0.0")
@file:DependsOn("org.openjfx:javafx-controls:21")
@file:DependsOn("org.openjfx:javafx-web:21")

import com.github.mouse0w0.darculafx.DarculaFX.applyDarculaStyle
import com.hexagonkt.http.server.HttpServerSettings
import com.hexagonkt.http.server.callbacks.FileCallback
import com.hexagonkt.http.server.netty.serve

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.layout.BorderPane
import javafx.scene.web.WebView
import javafx.stage.Stage
import kotlin.system.exitProcess

class SlidesBrowser : Application() {

    override fun start(stage: Stage) {

        stage.title = "Empezando con Kotlin"
        stage.isFullScreen = true
        stage.scene = Scene(
            BorderPane().apply {
                center = WebView().apply {
                    engine.load("http://localhost:2001")
                }
            }
        )

        applyDarculaStyle(stage.scene)

        stage.sizeToScene()
        stage.centerOnScreen()
        stage.show()
        stage.toFront()
    }

    override fun stop() {
        exitProcess(0)
    }
}

serve(HttpServerSettings(bindPort = 2001)) {
    get(callback = FileCallback("slides.html"))
    get(pattern = "/slides.md", callback = FileCallback("slides.md"))
}

Application.launch(SlidesBrowser::class.java)
