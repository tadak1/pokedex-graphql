import SwiftUI
import shared

struct ContentView: View {
	let greet = Greeting().greeting()
	var body: some View {
		Text(greet)
        Button(action: {
            Task {
                print(await getMediaPage())
            }
        }){
            Text(greet)
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
        return try await ExampleAniListClient().getMediaPage()
    } catch {
        print(error)
        return []
    }
}
