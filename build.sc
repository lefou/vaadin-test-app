import $ivy.`de.tototec::de.tobiasroeser.mill.vaadin::0.0.4-SNAPSHOT`

import mill._
import mill.scalalib._
import de.tobiasroeser.mill.vaadin._

object Deps {
  def springBootVersion = "3.2.3"
  def vaadinVersion = "24.3.7"

  val h2 = ivy"com.h2database:h2:2.2.224"
  val lineAwesome = ivy"org.parttio:line-awesome:2.0.0"
  val springBootStarterValidation = ivy"org.springframework.boot:spring-boot-starter-validation:${springBootVersion}"
  val springBootStarterDataJpa = ivy"org.springframework.boot:spring-boot-starter-data-jpa:${springBootVersion}"
  val springBootDevtools = ivy"org.springframework.boot:spring-boot-devtools:${springBootVersion}"
  val vaadin = ivy"com.vaadin:vaadin:${vaadinVersion}"
  val vaadinSpringBootStarter = ivy"com.vaadin:vaadin-spring-boot-starter:${vaadinVersion}"

}

object root extends RootModule with MavenModule with VaadinModule {

  override def vaadinVersion = Deps.vaadinVersion

  def ivyDeps = Agg(
    Deps.vaadin,
    Deps.vaadinSpringBootStarter,
    Deps.lineAwesome,
    Deps.springBootStarterDataJpa,
    Deps.springBootStarterValidation,
    Deps.springBootDevtools
  )
  def runIvyDeps = Agg(
    Deps.h2
  )
}