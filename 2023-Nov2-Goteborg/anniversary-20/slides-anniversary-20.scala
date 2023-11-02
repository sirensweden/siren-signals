//> using lib "taggy:taggy:0.0.5,url=https://github.com/bjornregnell/taggy/releases/download/v0.0.5/taggy_3-0.0.5.jar"
//> using scala "3.3.1"

import taggy.*

@main def makeSlides = 
  slides.toPdf(out = "slides-anniversary-20", dir = "tex")

def size(f: Int, s: Int): String = s"\\fontsize{$f}{$s}\\selectfont"

def slides = document("SiREN ANNIVERSARY 20 YEARS"):
  frame("SiREN Signals until now"):
    p(size(9,11) + "2023, Göteborg 2-3 Nov, **20 YEARS ANNIVERSARY**")
    p("(2020 planned for Göteborg, cancelled by Corona)")
    p("2019, Lund, May 7-8")
    p("2018, Linköping, May 7-8")
    p("2017, Karlskrona, May 11-12")
    p("2016, Stockholm, May 26-27")
    p("2015, Västerås, May 25-26")
    p("2013, Malmö, May 30-31, **10 YEARS ANNIVERSARY**")
    p("2012, Göteborg, May 3-4")
    p("2011, Jönköping, May 12-13")
    p("2010, Ronneby, April 26-27")
    p("2009, Lund April 27-28")
    p("2008, Umeå, March 27-28")
    p("2007, Göteborg, March 15-16 ")
    p("2006, Ronneby, May 23-24 ")
    p("2005, Skövde, April 14-15 ")
    p("2004, Linköping, October 20-21 ")
    p("2004, Stockholm, April 15-15 ")
    p("2003, Lund, October 22-23 ")
    p("2003, Lund, June 12-13     ")

  frame("The SiREN Founding Generation"):
    p("2nd Signal in Lund Oct 22, 2003")
    image("../../../2003-Oct22-Lund/signal2-participants.jpg", width = 1.05)

  frame("The Initial SiREN Agenda"):
    p("See first presentations here:\\\\\\vspace{1em}https://github.com/sirensweden/siren-signals/blob/main/2003-June11-Lund/")

  frame("Why SiREN?"):
    itemize:
      p("Gather all academic RE researchers in Sweden")
      p("Help PhD students build a network")
      p("Senior Faculty exchange and coordination")
      p("Pave the way for collaboration")
      p("Strengthen RE research in Sweden")
      p("Open, inclusive, friendly, fun, easy...")