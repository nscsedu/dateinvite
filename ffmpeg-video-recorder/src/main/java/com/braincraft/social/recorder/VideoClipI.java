package com.braincraft.social.recorder;

import com.braincraft.social.camera.CameraControllerI;

import java.io.File;

/**
 * Video clip with some additional metadata.
 */
interface VideoClipI {
    File getFile();
    CameraControllerI.Facing getFacing();
    int getOrientationDegrees();
}
