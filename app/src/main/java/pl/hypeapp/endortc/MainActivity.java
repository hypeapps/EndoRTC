package pl.hypeapp.endortc;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.webrtc.AudioSource;
import org.webrtc.AudioTrack;
import org.webrtc.CameraVideoCapturer;
import org.webrtc.EglBase;
import org.webrtc.MediaConstraints;
import org.webrtc.PeerConnection;
import org.webrtc.PeerConnectionFactory;
import org.webrtc.RendererCommon;
import org.webrtc.SurfaceTextureHelper;
import org.webrtc.SurfaceViewRenderer;
import org.webrtc.VideoCapturer;
import org.webrtc.VideoCapturerAndroid;
import org.webrtc.VideoRenderer;
import org.webrtc.VideoSource;
import org.webrtc.VideoTrack;

public class MainActivity extends AppCompatActivity implements CameraVideoCapturer.CameraEventsHandler {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PeerConnectionFactory.initializeAndroidGlobals(this, true, true, true);
        PeerConnectionFactory peerConnectionFactory = new PeerConnectionFactory();
        VideoCapturer videoCapturer = new VideoCapturer() {
            @Override
            public void initialize(SurfaceTextureHelper surfaceTextureHelper, Context context, CapturerObserver capturerObserver) {

            }

            @Override
            public void startCapture(int i, int i1, int i2) {

            }

            @Override
            public void stopCapture() throws InterruptedException {

            }

            @Override
            public void changeCaptureFormat(int i, int i1, int i2) {

            }

            @Override
            public void dispose() {

            }

            @Override
            public boolean isScreencast() {
                return false;
            }
        };
        VideoSource videoSource = peerConnectionFactory.createVideoSource(videoCapturer);
        VideoTrack videoTrack = peerConnectionFactory.createVideoTrack("TABS", videoSource);
        MediaConstraints mediaConstraints = new MediaConstraints();
        AudioSource audioSource = peerConnectionFactory.createAudioSource(mediaConstraints);
        AudioTrack audioTrack = peerConnectionFactory.createAudioTrack("TABS_AUDIO", audioSource);

        SurfaceViewRenderer glSurfaceView = (SurfaceViewRenderer) findViewById(R.id.fullscreen_video_view);
        EglBase rootEglBase = EglBase.create();
        glSurfaceView.init(rootEglBase.getEglBaseContext(), null);
        glSurfaceView.setScalingType(RendererCommon.ScalingType.SCALE_ASPECT_FILL);
        glSurfaceView.setEnableHardwareScaler(true /* enabled */);
    }

    @Override
    public void onCameraError(String s) {

    }

    @Override
    public void onCameraDisconnected() {

    }

    @Override
    public void onCameraFreezed(String s) {

    }

    @Override
    public void onCameraOpening(String s) {

    }

    @Override
    public void onFirstFrameAvailable() {

    }

    @Override
    public void onCameraClosed() {

    }
}
