package scala
import scala.collection.mutable.ListBuffer
import scala.util.control._
object LoadBalanceByScala extends App{
  val A=new Cate("A",50)
  val B=new Cate("B",40)
  val C=new Cate("C",10)
  val loop = new Breaks;
  val list = ListBuffer[Cate](A,B,C)
  var weightSum  = 0;
  for (ca <- list) {
    weightSum += ca.weight;
  }
  val n=(new util.Random).nextInt(weightSum)
  var m=0
  for (ca <-  list) {
    if (m <= n && n < m + ca.weight) {
      System.out.println("This Random LoadBalance is "+ca.id);
      loop.break;
    }
    m += ca.weight;



  }
}
