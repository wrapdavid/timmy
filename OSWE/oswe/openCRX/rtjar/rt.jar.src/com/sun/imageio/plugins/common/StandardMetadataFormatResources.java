/*    */ package com.sun.imageio.plugins.common;
/*    */ 
/*    */ import java.util.ListResourceBundle;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class StandardMetadataFormatResources
/*    */   extends ListResourceBundle
/*    */ {
/*    */   protected Object[][] getContents() {
/* 35 */     return new Object[][] { { "Chroma", "Chroma (color) information" }, { "ColorSpaceType", "The raw color space of the image" }, { "NumChannels", "The number of channels in the raw image, including alpha" }, { "Gamma", "The image gamma" }, { "BlackIsZero", "True if smaller values represent darker shades" }, { "Palette", "Palette-color information" }, { "PaletteEntry", "A palette entry" }, { "PaletteEntry/index", "The index of the palette entry" }, { "PaletteEntry/red", "The red value for the palette entry" }, { "PaletteEntry/green", "The green value for the palette entry" }, { "PaletteEntry/blue", "The blue value for the palette entry" }, { "PaletteEntry/alpha", "The alpha value for the palette entry" }, { "BackgroundIndex", "A palette index to be used as a background" }, { "BackgroundColor", "An RGB triple to be used as a background" }, { "BackgroundColor/red", "The red background value" }, { "BackgroundColor/green", "The green background value" }, { "BackgroundColor/blue", "The blue background value" }, { "Compression", "Compression information" }, { "CompressionTypeName", "The name of the compression scheme in use" }, { "Lossless", "True if the compression scheme is lossless" }, { "BitRate", "The estimated bit rate of the compression scheme" }, { "NumProgressiveScans", "The number of progressive scans used in the image encoding" }, { "Data", "Information on the image layout" }, { "PlanarConfiguration", "The organization of image samples in the stream" }, { "SampleFormat", "The numeric format of image samples" }, { "BitsPerSample", "The number of bits per sample" }, { "BitsPerSample/value", "A list of integers, one per channel" }, { "SignificantBitsPerSample", "The number of significant bits per sample" }, { "SignificantBitsPerSample/value", "A list of integers, one per channel" }, { "SampleMSB", "The position of the most significant bit of each sample" }, { "SampleMSB/value", "A list of integers, one per channel" }, { "Dimension", "Dimension information" }, { "PixelAspectRatio", "The width of a pixel divided by its height" }, { "ImageOrientation", "The desired orientation of the image in terms of flips and counter-clockwise rotations" }, { "HorizontalPixelSize", "The width of a pixel, in millimeters, as it should be rendered on media" }, { "VerticalPixelSize", "The height of a pixel, in millimeters, as it should be rendered on media" }, { "HorizontalPhysicalPixelSpacing", "The horizontal distance in the subject of the image, in millimeters, represented by one pixel at the center of the image" }, { "VerticalPhysicalPixelSpacing", "The vertical distance in the subject of the image, in millimeters, represented by one pixel at the center of the image" }, { "HorizontalPosition", "The horizontal position, in millimeters, where the image should be rendered on media " }, { "VerticalPosition", "The vertical position, in millimeters, where the image should be rendered on media " }, { "HorizontalPixelOffset", "The horizontal position, in pixels, where the image should be rendered onto a raster display" }, { "VerticalPixelOffset", "The vertical position, in pixels, where the image should be rendered onto a raster display" }, { "HorizontalScreenSize", "The width, in pixels, of the raster display into which the image should be rendered" }, { "VerticalScreenSize", "The height, in pixels, of the raster display into which the image should be rendered" }, { "Document", "Document information" }, { "FormatVersion", "The version of the format used by the stream" }, { "SubimageInterpretation", "The interpretation of this image in relation to the other images stored in the same stream" }, { "ImageCreationTime", "The time of image creation" }, { "ImageCreationTime/year", "The full year (e.g., 1967, not 67)" }, { "ImageCreationTime/month", "The month, with January = 1" }, { "ImageCreationTime/day", "The day of the month" }, { "ImageCreationTime/hour", "The hour from 0 to 23" }, { "ImageCreationTime/minute", "The minute from 0 to 59" }, { "ImageCreationTime/second", "The second from 0 to 60 (60 = leap second)" }, { "ImageModificationTime", "The time of the last image modification" }, { "ImageModificationTime/year", "The full year (e.g., 1967, not 67)" }, { "ImageModificationTime/month", "The month, with January = 1" }, { "ImageModificationTime/day", "The day of the month" }, { "ImageModificationTime/hour", "The hour from 0 to 23" }, { "ImageModificationTime/minute", "The minute from 0 to 59" }, { "ImageModificationTime/second", "The second from 0 to 60 (60 = leap second)" }, { "Text", "Text information" }, { "TextEntry", "A text entry" }, { "TextEntry/keyword", "A keyword associated with the text entry" }, { "TextEntry/value", "the text entry" }, { "TextEntry/language", "The language of the text" }, { "TextEntry/encoding", "The encoding of the text" }, { "TextEntry/compression", "The method used to compress the text" }, { "Transparency", "Transparency information" }, { "Alpha", "The type of alpha information contained in the image" }, { "TransparentIndex", "A palette index to be treated as transparent" }, { "TransparentColor", "An RGB color to be treated as transparent" }, { "TransparentColor/red", "The red channel of the transparent color" }, { "TransparentColor/green", "The green channel of the transparent color" }, { "TransparentColor/blue", "The blue channel of the transparent color" }, { "TileTransparencies", "A list of completely transparent tiles" }, { "TransparentTile", "The index of a completely transparent tile" }, { "TransparentTile/x", "The tile's X index" }, { "TransparentTile/y", "The tile's Y index" }, { "TileOpacities", "A list of completely opaque tiles" }, { "OpaqueTile", "The index of a completely opaque tile" }, { "OpaqueTile/x", "The tile's X index" }, { "OpaqueTile/y", "The tile's Y index" } };
/*    */   }
/*    */ }


/* Location:              /Users/timmy/timmy/OSWE/oswe/openCRX/rt.jar!/com/sun/imageio/plugins/common/StandardMetadataFormatResources.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */