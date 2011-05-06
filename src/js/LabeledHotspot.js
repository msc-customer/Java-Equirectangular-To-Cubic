/*
 * Copyright 2010 Leo Sutic <leo.sutic@gmail.com>
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
    
/**
 * Creates a new labeled hotspot instance.
 *
 * @class A hotspot with a label under it. The label element can be accessed using
 * the getLabel method and styled as any HTMLElement. See {@link bigshot.HotspotLayer} for 
 * examples.
 *
 * @see bigshot.HotspotLayer
 * @param {number} x x-coordinate of the top-left corner, given in full image pixels
 * @param {number} y y-coordinate of the top-left corner, given in full image pixels
 * @param {number} w width of the hotspot, given in full image pixels
 * @param {number} h height of the hotspot, given in full image pixels
 * @param {String} labelText text of the label
 * @augments bigshot.Hotspot
 * @constructor
 */
bigshot.LabeledHotspot = function (x, y, w, h, labelText) {
    var hs = new bigshot.Hotspot (x, y, w, h);
    
    /**
     * Returns the label element.
     *
     * @type HTMLDivElement
     */
    this.getLabel = function () {
        return this.label;
    };
    
    this.layout = function (x0, y0, zoomFactor) {
        this._super.layout (x0, y0, zoomFactor);
        var labelSize = this.browser.getElementSize (this.label);
        var sw = this.w * zoomFactor;
        var sh = this.h * zoomFactor;
        this.label.style.top = (sh + 4) + "px";
        this.label.style.left = ((sw - labelSize.w) / 2) + "px";
    };
    
    this.label = document.createElement ("div");
    this.label.style.position = "relative";
    this.label.style.display = "inline-block";
    
    hs.getElement ().appendChild (this.label);
    this.label.innerHTML = labelText;
    
    return bigshot.object.extend (hs, this);
};
