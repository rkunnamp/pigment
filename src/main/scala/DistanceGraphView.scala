package pigment

import scala.scalajs.js
import js.annotation._
import js.JSConverters._
import org.scalajs.dom._

import japgolly.scalajs.react._
import japgolly.scalajs.react.vdom.prefix_<^._

import org.singlespaced.d3js
import org.singlespaced.d3js._
import org.singlespaced.d3js.d3
import org.singlespaced.d3js.Ops._
import org.singlespaced.d3js.Link
import org.singlespaced.d3js.forceModule.Force

import diode._
import diode.react._

import scala.util.Try

import scalax.collection.Graph
import scalax.collection.GraphPredef._
import scalax.collection.GraphEdge._

object DistanceGraphView extends graphView.GraphView[Color, DiEdge] {
  override val reuseVertexCoordinatesOnUpdate = true
  override def linkDistance(e: DiEdge[Color]) = ColorDistance.ciede2000(e.source.lab, e.target.lab)
  override def charge(v: Color) = 0
  override def linkStrength(e: DiEdge[Color]) = 1
  override def styleVertices(sel: VertexSelection) = {
    super.styleVertices(sel)
      .attr("r", 10.0)
      .style("fill", (d: D3Vertex) => d.v.toCSS)
  }
}
