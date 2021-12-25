//
//  AppDelegate.swift
//  iosApp
//
//  Created by tada koichi on 2021/12/25.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared
import UIKit

class AppDelegate: NSObject, UIApplicationDelegate {
    func application(_: UIApplication, didFinishLaunchingWithOptions _: [UIApplication.LaunchOptionsKey: Any]? = nil) -> Bool {
        KoinKt.doInitKoinForIOS()
        return true
    }
}
