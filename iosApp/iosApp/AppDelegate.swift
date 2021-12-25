//
//  AppDelegate.swift
//  iosApp
//
//  Created by tada koichi on 2021/12/25.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import UIKit
import shared

class AppDelegate: NSObject, UIApplicationDelegate {
    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey : Any]? = nil) -> Bool {
        KoinKt.doInitKoinForIOS()
        return true
    }
}
