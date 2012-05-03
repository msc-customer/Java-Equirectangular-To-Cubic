/*
 * Copyright 2010 - 2012 Leo Sutic <leo.sutic@gmail.com>
 *  
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0 
 *     
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 */
package bigshot;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.ImageReader;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

import java.util.StringTokenizer;
import java.util.Iterator;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

/**
 * Math utility functions.
 */
public class MathUtil {
    
    /**
     * Private ctor.
     */
    private MathUtil () {
    }
    
    /**
     * Converts degrees to radians.
     *
     * @param deg the angle in degrees
     * @return the angle in radians
     */
    public static double toRad (double deg) {
        return deg * Math.PI / 180;
    }
    
    /**
     * Converts radians to degrees.
     *
     * @param rad the angle in radians
     * @return the angle in degrees
     */
    public static double toDeg (double rad) {
        return rad * 180 / Math.PI;
    }
        
    /**
     * Clamps the value between two endpoints.
     *
     * @param a the lowest value that will be returned
     * @param b the highest value that will be returned
     * @param x the value to clamp
     * @return a, if x &lt;= a; b, if x &gt;= b; x otherwise
     */
    public static int clamp (int a, int x, int b) {
        if (x < a) {
            return a;
        } else if (x > b) {
            return b;
        } else {
            return x;
        }
    }
}