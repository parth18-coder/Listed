package com.example.listed.presentation.homeScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.listed.data.remote.dto.ListedDto
import kotlin.reflect.full.declaredMemberProperties



fun prepareChartData(dataState: ListedDto?):List<Pair<String,Int>> {
    if (dataState != null) {
        val chartData = dataState?.data?.overallUrlChart
        if (chartData != null) {
            val keys = chartData::class.declaredMemberProperties.map { it.name }

            val values = chartData::class.declaredMemberProperties.map { property ->
                property.getter.call(chartData) as Int
            }

            val data: List<Pair<String, Int>> = keys.zip(values)

            return data
        }
    }
    return emptyList<Pair<String, Int>>()
}

fun generatePath(data: List<Pair<String, Int>>, size: Size): Path {

    val maxValue = data.maxByOrNull { it.second }?.second ?: 0

    val path = Path()

    if (data.isNotEmpty()) {
        val xStep = size.width / (data.size - 1).toFloat()
        val yStep = size.height / maxValue.toFloat()

        path.reset()

        data.forEachIndexed { index, (data, value) ->
            val x = index * xStep
            val y = size.height - (value * yStep)

            if (index == 0) {
                path.moveTo(x, y)
            } else {
                path.lineTo(x, y)
            }

            //drawCircle(Color.Blue,radius=4.dp.toPx(),center= Offset(x,y))
        }

    }

    return path


}


@Composable
fun ChartComposable(dataState: ListedDto?) {

    val data = prepareChartData(dataState)

    Box(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .border(BorderStroke(1.dp, Color.Black), shape = RoundedCornerShape(8.dp))
            .background(Color(0xFFFFFFFF))
            .padding(top = 8.dp, bottom = 16.dp), contentAlignment = Alignment.Center
    ) {

        Canvas(
            modifier = Modifier
                .padding(8.dp)
                .aspectRatio(3 / 2f)
                .fillMaxSize()
        ) {
            val barWidthPx = 1.dp.toPx()
            drawRect(color = Color(0xFF000000), style = Stroke(barWidthPx))


            val verticalLines = 12
            val verticalSize = size.width / (verticalLines + 1)

            repeat(verticalLines) { i ->
                val startX = verticalSize * (i + 1)

                drawLine(
                    Color(0xFFF2F2F2),
                    start = Offset(startX, 0f),
                    end = Offset(startX, size.height),
                    strokeWidth = barWidthPx
                )
            }

            val horizontalLines = 12
            val horizontalSize = size.height / (horizontalLines + 1)

            repeat(horizontalLines) { i ->
                val startY = horizontalSize * (i + 1)

                drawLine(
                    Color(0xFFF2F2F2),
                    start = Offset(0f, startY),
                    end = Offset(size.width, startY),
                    strokeWidth = barWidthPx
                )
            }


            val path = generatePath(data, size)


            val gradientBrush = Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF0E6FFF).copy(alpha = 0.8f), Color.Transparent
                ),
            )

            val fillPath = android.graphics.Path(path.asAndroidPath())
                .asComposePath()
                .apply {
                    lineTo(0f, size.height)
                    lineTo(size.width, size.height)
                    close()
                }


            drawPath(
                path = fillPath,
                brush = gradientBrush,
            )


            drawPath(
                path = path,
                color = Color(0xFF0E6FFF),
                style = Stroke(width = 2.dp.toPx())
            )

        }
    }
}