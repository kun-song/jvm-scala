package com.satansk.jvm

import cats.implicits._
import com.monovore.decline._

object Main extends CommandApp (
  name = "jvm",
  header = "A purely functional JVM written in Scala!",
  main = {
    val pathOpt = Opts.option[String]("target", help = "The class files you want to run.").withDefault("./")
    val jitOpt = Opts.flag("jit", help = "Whether to use JIT.").orFalse

    (pathOpt, jitOpt).mapN { (path, jit) ⇒
      if (jit) println("You are using JIT now.")
      else println(s"Interpret class file in $path")
    }
  }
)
