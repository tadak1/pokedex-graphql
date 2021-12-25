import SwiftUI
import UIKit

@main
struct iOSApp: App {
    @UIApplicationDelegateAdaptor(AppDelegate.self) var appDelegate
    
	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
