import SwiftUI
import sharedVideoPlayer

let videoPlayerController = VideoPlayerControllerFactory().createVideoPlayer()

struct ContentView: View {
    var body: some View {
        ComposeView()
    }
}

#Preview {
    ContentView()
}
