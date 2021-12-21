import SwiftUI
import shared

struct ContentView: View {
	var body: some View {
        Button(action: {
            Task {
                print(await getMediaPage())
            }
        }){
            Text("greet")
        }
	}
}

struct ContentView_Previews: PreviewProvider {
	static var previews: some View {
		ContentView()
	}
}

func getMediaPage() async -> [GetPagesQuery.Medium]? {
    do {
        return try await AnimeListClient().getMediaPage()
    } catch {
        print(error)
        return []
    }
}
