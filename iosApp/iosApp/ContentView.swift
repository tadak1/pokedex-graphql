import SwiftUI
import Kingfisher
import shared

@MainActor
struct ContentView: View {
    @StateObject var viewModel = MediaViewModel(repository: MediaRepository())
    
	var body: some View {
        TabView {
            NavigationView {
                ScrollView {
                    LazyVStack {
                        Text("Test")
                        if viewModel.isLoading {
                            ProgressView()                            
                        } else {
                            ForEach(viewModel.mediaList, id: \.self) { media in
                                KFImage.url(
                                     URL(string: media.coverImage?.large ?? ""),
                                    cacheKey: media.coverImage?.large ?? ""
                                )
                            }
                        }
                        Button(action: {
                            Task {
                               print(await viewModel.fetch())
                            }
                        }) {
                            Text("fetch")
                        }
                    }
                }
            }.tabItem {
                Label("Test", systemImage: "location")
            }
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}



@MainActor
class MediaViewModel: ObservableObject {
    private let repository: MediaRepository
    
    @Published var isLoading: Bool  = false
    @Published var mediaList: [GetPagesQuery.Medium] = []
    
    init(repository: MediaRepository){
        self.repository = repository
    }
    
    func fetch() async {
        defer {
            isLoading = false
        }
        do {
            isLoading = true
            if let fetchedMediaList = try await repository.fetchMedia() {
                mediaList = fetchedMediaList
            }
        } catch {
            print(error)
        }
    }
}
