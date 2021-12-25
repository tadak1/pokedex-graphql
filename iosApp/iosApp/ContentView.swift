import SwiftUI
import shared

@MainActor
struct ContentView: View {
    @StateObject var viewModel = MediaViewModel(repository: MediaRepository())
    
	var body: some View {
        TabView {
            NavigationView {
                VStack {
                    Text("Test")
                    Button(action: {
                        Task {
                           print(await viewModel.fetch())
                        }
                    }) {
                        Text("fetch")
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



class MediaViewModel: ObservableObject {
    private let repository: MediaRepository
    
    init(repository: MediaRepository){
        self.repository = repository
    }
    
    func fetch() async -> [GetPagesQuery.Medium]? {
        do {
            return try await repository.fetchMedia()
        } catch {
            print(error)
            return nil
        }
    }
}
