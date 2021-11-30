#import "SlowInternetPlugin.h"
#if __has_include(<slow_internet_plugin/slow_internet_plugin-Swift.h>)
#import <slow_internet_plugin/slow_internet_plugin-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "slow_internet_plugin-Swift.h"
#endif

@implementation SlowInternetPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftSlowInternetPlugin registerWithRegistrar:registrar];
}
@end
